package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.SystemUser;
import com.fairychar.security.core.rbac.pojo.dto.SystemUserDTO;
import com.fairychar.security.core.rbac.pojo.query.SystemUserQuery;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统用户(SystemUser)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface SystemUserStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link SystemUser}
     * @return dto对象 {@link SystemUserDTO}
     */
    default List<SystemUserDTO> entitiesToDtos(List<SystemUser> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link SystemUser}
     * @return dto对象 {@link SystemUserDTO}
     */
    SystemUserDTO entityToDto(SystemUser entity);

    /**
     * queries转entities
     *
     * @param queries {@link SystemUserQuery}
     * @return entity对象 {@link SystemUser}
     */
    default List<SystemUser> queriesToEntities(List<SystemUserQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link SystemUserQuery}
     * @return entity对象 {@link SystemUser}
     */
    SystemUser queryToEntity(SystemUserQuery query);

}
