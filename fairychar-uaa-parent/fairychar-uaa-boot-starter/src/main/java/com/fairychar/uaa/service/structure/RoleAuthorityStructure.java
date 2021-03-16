package com.fairychar.uaa.service.structure;


import com.fairychar.uaa.entity.RoleAuthority;
import com.fairychar.uaa.pojo.dto.RoleAuthorityDTO;
import com.fairychar.uaa.pojo.query.RoleAuthorityQuery;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * (RoleAuthority)表数据库实体转换器
 *
 * @author chiyo
 * @since 2021-02-08 17:38:47
 */
@Mapper(componentModel = "spring", uses = {})
public interface RoleAuthorityStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link RoleAuthority}
     * @return dto对象 {@link RoleAuthorityDTO}
     */
    List<RoleAuthorityDTO> entitiesToDtos(List<RoleAuthority> entities);

    /**
     * entity转dto
     *
     * @param entity {@link RoleAuthority}
     * @return dto对象 {@link RoleAuthorityDTO}
     */
    RoleAuthorityDTO entityToDto(RoleAuthority entity);

    /**
     * queries转entities
     *
     * @param queries {@link RoleAuthorityQuery}
     * @return entity对象 {@link RoleAuthority}
     */
    List<RoleAuthority> queriesToEntities(List<RoleAuthorityQuery> queries);

    /**
     * query转entity
     *
     * @param query {@link RoleAuthorityQuery}
     * @return entity对象 {@link RoleAuthority}
     */
    RoleAuthority queryToEntity(RoleAuthorityQuery query);

}