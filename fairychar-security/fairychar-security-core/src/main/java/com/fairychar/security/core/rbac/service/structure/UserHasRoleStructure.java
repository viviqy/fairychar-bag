package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.UserHasRole;
import com.fairychar.security.core.rbac.pojo.dto.UserHasRoleDTO;
import com.fairychar.security.core.rbac.pojo.query.UserHasRoleQuery;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色关联(UserHasRole)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserHasRoleStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link UserHasRole}
     * @return dto对象 {@link UserHasRoleDTO}
     */
    default List<UserHasRoleDTO> entitiesToDtos(List<UserHasRole> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link UserHasRole}
     * @return dto对象 {@link UserHasRoleDTO}
     */
    UserHasRoleDTO entityToDto(UserHasRole entity);

    /**
     * queries转entities
     *
     * @param queries {@link UserHasRoleQuery}
     * @return entity对象 {@link UserHasRole}
     */
    default List<UserHasRole> queriesToEntities(List<UserHasRoleQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link UserHasRoleQuery}
     * @return entity对象 {@link UserHasRole}
     */
    UserHasRole queryToEntity(UserHasRoleQuery query);

}
