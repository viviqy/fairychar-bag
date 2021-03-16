package com.fairychar.uaa.service.structure;


import com.fairychar.uaa.entity.Role;
import com.fairychar.uaa.pojo.dto.RoleDTO;
import com.fairychar.uaa.pojo.query.RoleQuery;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * (Role)表数据库实体转换器
 *
 * @author chiyo
 * @since 2021-02-08 17:38:44
 */
@Mapper(componentModel = "spring", uses = {})
public interface RoleStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link Role}
     * @return dto对象 {@link RoleDTO}
     */
    List<RoleDTO> entitiesToDtos(List<Role> entities);

    /**
     * entity转dto
     *
     * @param entity {@link Role}
     * @return dto对象 {@link RoleDTO}
     */
    RoleDTO entityToDto(Role entity);

    /**
     * queries转entities
     *
     * @param queries {@link RoleQuery}
     * @return entity对象 {@link Role}
     */
    List<Role> queriesToEntities(List<RoleQuery> queries);

    /**
     * query转entity
     *
     * @param query {@link RoleQuery}
     * @return entity对象 {@link Role}
     */
    Role queryToEntity(RoleQuery query);

}