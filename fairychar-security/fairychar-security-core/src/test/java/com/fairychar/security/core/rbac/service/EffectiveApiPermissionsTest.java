package com.fairychar.security.core.rbac.service;

import com.fairychar.security.core.rbac.mapper.SysApiMapper;
import com.fairychar.security.core.rbac.pojo.dto.SysApiDTO;
import com.fairychar.security.core.rbac.service.structure.SysApiStructure;
import com.fairychar.bag.domain.exceptions.RestErrorCode;
import com.fairychar.bag.domain.exceptions.RestException;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

public class EffectiveApiPermissionsTest {
    private SqlSession session;
    private SysApiService service;
    private JdbcDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        this.dataSource = new JdbcDataSource();
        this.dataSource.setURL("jdbc:h2:mem:" + UUID.randomUUID() + ";MODE=MySQL;DB_CLOSE_DELAY=-1");
        execute("create table sys_api (id int primary key, http_method varchar(16), uri varchar(255),"
                + " description varchar(255), sort int, create_by bigint, create_name varchar(64),"
                + " update_by bigint, update_name varchar(64), create_time timestamp, update_time timestamp)",
                "create table system_role (id int primary key, enable boolean, level int)",
                "create table sys_menu (id int primary key, enable boolean, hidden boolean, pid int)",
                "create table user_has_role (user_uid bigint, role_id int)",
                "create table role_has_menu (role_id int, menu_id int)",
                "create table menu_has_api (menu_id int, api_id int)",
                "insert into sys_api (id,http_method,uri,sort) values (1,'GET','/orders',2),"
                        + "(2,'POST','/orders',1),(3,'GET','/admin',3)",
                "insert into system_role values (1,true,1),(2,true,1),(3,false,1),(4,null,1),(5,true,0)",
                "insert into sys_menu values (1,true,false,0),(2,true,true,0),(3,false,false,0),(4,null,false,0)",
                "insert into user_has_role values (10000000001,1),(10000000001,2),(10000000002,3),"
                        + "(10000000003,4),(10000000004,5)",
                "insert into role_has_menu values (1,1),(2,1),(2,2),(3,1),(4,1),(5,1)",
                "insert into menu_has_api values (1,1),(1,1),(2,2)");
        Configuration configuration = new Configuration(new Environment("test", new JdbcTransactionFactory(), this.dataSource));
        String resource = "mapper/SysApiMapper.xml";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(resource)) {
            Assert.assertNotNull(input);
            new XMLMapperBuilder(input, configuration, resource, configuration.getSqlFragments()).parse();
        }
        this.session = new SqlSessionFactoryBuilder().build(configuration).openSession(true);
        this.service = new SysApiService();
        ReflectionTestUtils.setField(this.service, "sysApiMapper", this.session.getMapper(SysApiMapper.class));
        ReflectionTestUtils.setField(this.service, "sysApiStructure", Mappers.getMapper(SysApiStructure.class));
    }

    @After
    public void tearDown() throws Exception {
        if (this.session != null) {
            this.session.close();
        }
        if (this.dataSource != null) {
            execute("drop all objects");
        }
    }

    @Test
    public void aggregatesOverlappingRolesAndHiddenMenusWithoutDuplicates() throws Exception {
        List<SysApiDTO> apis = find(10000000001L);
        Assert.assertEquals(List.of(2, 1), apis.stream().map(SysApiDTO::getId).toList());
        Assert.assertEquals(List.of("POST", "GET"), apis.stream().map(SysApiDTO::getHttpMethod).toList());
    }

    @Test
    public void returnsEmptyForUnknownUid() throws Exception {
        Assert.assertTrue(find(999L).isEmpty());
    }

    @Test
    public void excludesDisabledAndNullEnabledRoles() throws Exception {
        Assert.assertTrue(find(10000000002L).isEmpty());
        Assert.assertTrue(find(10000000003L).isEmpty());
    }

    @Test
    public void excludesDisabledAndNullEnabledMenus() throws Exception {
        execute("update sys_menu set enable=false where id=1", "update sys_menu set enable=null where id=2");
        Assert.assertTrue(find(10000000001L).isEmpty());
    }

    @Test
    public void doesNotGrantUnrelatedOrDanglingPermissions() throws Exception {
        execute("insert into user_has_role values (10000000001,99)",
                "insert into role_has_menu values (99,1),(1,99)",
                "insert into menu_has_api values (99,3),(1,99)");
        Assert.assertEquals(List.of(2, 1), find(10000000001L).stream().map(SysApiDTO::getId).toList());
        Assert.assertEquals(List.of(1), find(10000000004L).stream().map(SysApiDTO::getId).toList());
    }

    @Test
    public void rootLevelDoesNotImplicitlyGrantAllApis() throws Exception {
        Assert.assertEquals(List.of(1), find(10000000004L).stream().map(SysApiDTO::getId).toList());
    }

    @Test
    public void subsequentQueryReflectsRevocation() throws Exception {
        Assert.assertEquals(2, find(10000000001L).size());
        execute("delete from user_has_role where user_uid=10000000001");
        Assert.assertTrue(find(10000000001L).isEmpty());
    }

    @Test
    public void keepsOtherRoleGrantWhenOneAssociationIsRevoked() throws Exception {
        execute("delete from user_has_role where user_uid=10000000001 and role_id=1");
        Assert.assertEquals(List.of(2, 1), find(10000000001L).stream().map(SysApiDTO::getId).toList());
        execute("delete from role_has_menu where role_id=2 and menu_id=1");
        Assert.assertEquals(List.of(2), find(10000000001L).stream().map(SysApiDTO::getId).toList());
    }

    @Test
    public void doesNotTreatPrimaryKeyOrOtherUidAsCurrentUser() throws Exception {
        execute("insert into user_has_role values (1,2)", "insert into role_has_menu values (2,3)",
                "insert into menu_has_api values (3,3)");
        Assert.assertTrue(find(100L).isEmpty());
        Assert.assertEquals(List.of(2, 1), find(1L).stream().map(SysApiDTO::getId).toList());
        execute("delete from user_has_role where user_uid=1");
        Assert.assertTrue(find(1L).isEmpty());
        Assert.assertEquals(2, find(10000000001L).size());
    }

    @Test
    public void rejectsNullUidInsteadOfQueryingAllPermissions() {
        RestException exception = Assert.assertThrows(RestException.class, () -> find(null));
        Assert.assertEquals(RestErrorCode.PARAM_INVALIDATE, exception.getErrorCode());
    }

    private List<SysApiDTO> find(Long userUid) {
        return this.service.listEffectiveByUserUid(userUid);
    }

    private void execute(String... statements) throws Exception {
        try (Connection connection = this.dataSource.getConnection(); Statement statement = connection.createStatement()) {
            for (String sql : statements) {
                statement.execute(sql);
            }
        }
    }
}
