package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.SystemRole;
import com.fairychar.security.core.rbac.pojo.dto.SystemRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSystemRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.SystemRoleQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSystemRoleQuery;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色表(SystemRole)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface SystemRoleStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link SystemRole}
     * @return dto对象 {@link SystemRoleDTO}
     */
    default List<SystemRoleDTO> entitiesToDtos(List<SystemRole> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link SystemRole}
     * @return dto对象 {@link SystemRoleDTO}
     */
    SystemRoleDTO entityToDto(SystemRole entity);

    /**
     * queries转entities
     *
     * @param queries {@link SystemRoleQuery}
     * @return entity对象 {@link SystemRole}
     */
    default List<SystemRole> queriesToEntities(List<SystemRoleQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link SystemRoleQuery}
     * @return entity对象 {@link SystemRole}
     */
    SystemRole queryToEntity(SystemRoleQuery query);

    SystemRole addQueryToEntity(AddSystemRoleQuery addSystemRoleQuery);

    SystemRole updateQueryToEntity(UpdateSystemRoleQuery updateSystemRoleQuery);

    List<SystemRole> addQueriesToEntities(List<AddSystemRoleQuery> batch);

    List<SystemRole> updateQueriesToEntities(List<UpdateSystemRoleQuery> batch);
}
