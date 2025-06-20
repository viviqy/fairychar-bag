package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.SysApi;
import com.fairychar.security.core.rbac.pojo.dto.SysApiDTO;
import com.fairychar.security.core.rbac.pojo.query.SysApiQuery;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.stream.Collectors;

/**
 * (SysApi)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface SysApiStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link SysApi}
     * @return dto对象 {@link SysApiDTO}
     */
    default List<SysApiDTO> entitiesToDtos(List<SysApi> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link SysApi}
     * @return dto对象 {@link SysApiDTO}
     */
    SysApiDTO entityToDto(SysApi entity);

    /**
     * queries转entities
     *
     * @param queries {@link SysApiQuery}
     * @return entity对象 {@link SysApi}
     */
    default List<SysApi> queriesToEntities(List<SysApiQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link SysApiQuery}
     * @return entity对象 {@link SysApi}
     */
    SysApi queryToEntity(SysApiQuery query);

}
