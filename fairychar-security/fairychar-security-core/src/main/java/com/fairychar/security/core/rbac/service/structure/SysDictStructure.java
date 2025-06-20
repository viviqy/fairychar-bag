package com.fairychar.security.core.rbac.service.structure;


import com.fairychar.security.core.rbac.entity.SysDict;
import com.fairychar.security.core.rbac.pojo.dto.SysDictDTO;
import com.fairychar.security.core.rbac.pojo.query.SysDictQuery;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据字典详情(SysDict)表数据库实体转换器
 *
 * @author chiyo
 */
@Mapper(componentModel = "spring", uses = {})
public interface SysDictStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link SysDict}
     * @return dto对象 {@link SysDictDTO}
     */
    default List<SysDictDTO> entitiesToDtos(List<SysDict> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    /**
     * entity转dto
     *
     * @param entity {@link SysDict}
     * @return dto对象 {@link SysDictDTO}
     */
    SysDictDTO entityToDto(SysDict entity);

    /**
     * queries转entities
     *
     * @param queries {@link SysDictQuery}
     * @return entity对象 {@link SysDict}
     */
    default List<SysDict> queriesToEntities(List<SysDictQuery> queries) {
        if (queries == null) {
            return null;
        }
        return queries.stream().map(this::queryToEntity).collect(Collectors.toList());
    }

    /**
     * query转entity
     *
     * @param query {@link SysDictQuery}
     * @return entity对象 {@link SysDict}
     */
    SysDict queryToEntity(SysDictQuery query);

}
