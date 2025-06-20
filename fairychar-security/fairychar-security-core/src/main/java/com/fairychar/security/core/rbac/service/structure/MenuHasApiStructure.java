package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.MenuHasApi;
import com.fairychar.security.core.rbac.pojo.dto.MenuHasApiDTO;
import com.fairychar.security.core.rbac.pojo.query.MenuHasApiQuery;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.stream.Collectors;

/**
 * (MenuHasApi)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface MenuHasApiStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link MenuHasApi}
     * @return dto对象 {@link MenuHasApiDTO}
     */
    default List<MenuHasApiDTO> entitiesToDtos(List<MenuHasApi> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link MenuHasApi}
     * @return dto对象 {@link MenuHasApiDTO}
     */
    MenuHasApiDTO entityToDto(MenuHasApi entity);

    /**
     * queries转entities
     *
     * @param queries {@link MenuHasApiQuery}
     * @return entity对象 {@link MenuHasApi}
     */
    default List<MenuHasApi> queriesToEntities(List<MenuHasApiQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link MenuHasApiQuery}
     * @return entity对象 {@link MenuHasApi}
     */
    MenuHasApi queryToEntity(MenuHasApiQuery query);

}
