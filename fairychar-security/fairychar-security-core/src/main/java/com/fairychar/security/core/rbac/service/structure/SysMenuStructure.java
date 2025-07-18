package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.SysMenu;
import com.fairychar.security.core.rbac.pojo.dto.SysMenuDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSysMenuQuery;
import com.fairychar.security.core.rbac.pojo.query.SysMenuQuery;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统菜单(SysMenu)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface SysMenuStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link SysMenu}
     * @return dto对象 {@link SysMenuDTO}
     */
    default List<SysMenuDTO> entitiesToDtos(List<SysMenu> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link SysMenu}
     * @return dto对象 {@link SysMenuDTO}
     */
    SysMenuDTO entityToDto(SysMenu entity);

    /**
     * queries转entities
     *
     * @param queries {@link SysMenuQuery}
     * @return entity对象 {@link SysMenu}
     */
    default List<SysMenu> queriesToEntities(List<SysMenuQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link SysMenuQuery}
     * @return entity对象 {@link SysMenu}
     */
    SysMenu queryToEntity(SysMenuQuery query);

    SysMenu addQueryToEntity(AddSysMenuQuery addSysMenuQuery);
}
