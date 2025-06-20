package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.RoleHasMenu;
import com.fairychar.security.core.rbac.pojo.dto.RoleHasMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.RoleHasMenuQuery;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色菜单关联(RoleHasMenu)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface RoleHasMenuStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link RoleHasMenu}
     * @return dto对象 {@link RoleHasMenuDTO}
     */
    default List<RoleHasMenuDTO> entitiesToDtos(List<RoleHasMenu> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link RoleHasMenu}
     * @return dto对象 {@link RoleHasMenuDTO}
     */
    RoleHasMenuDTO entityToDto(RoleHasMenu entity);

    /**
     * queries转entities
     *
     * @param queries {@link RoleHasMenuQuery}
     * @return entity对象 {@link RoleHasMenu}
     */
    default List<RoleHasMenu> queriesToEntities(List<RoleHasMenuQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link RoleHasMenuQuery}
     * @return entity对象 {@link RoleHasMenu}
     */
    RoleHasMenu queryToEntity(RoleHasMenuQuery query);

}
