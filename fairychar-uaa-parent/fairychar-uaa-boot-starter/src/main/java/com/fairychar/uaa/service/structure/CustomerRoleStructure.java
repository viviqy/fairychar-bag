package com.fairychar.uaa.service.structure;


import com.fairychar.uaa.entity.CustomerRole;
import com.fairychar.uaa.pojo.dto.CustomerRoleDTO;
import com.fairychar.uaa.pojo.query.CustomerRoleQuery;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * (CustomerRole)表数据库实体转换器
 *
 * @author chiyo
 * @since 2021-02-08 17:38:35
 */
@Mapper(componentModel = "spring", uses = {})
public interface CustomerRoleStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link CustomerRole}
     * @return dto对象 {@link CustomerRoleDTO}
     */
    List<CustomerRoleDTO> entitiesToDtos(List<CustomerRole> entities);

    /**
     * entity转dto
     *
     * @param entity {@link CustomerRole}
     * @return dto对象 {@link CustomerRoleDTO}
     */
    CustomerRoleDTO entityToDto(CustomerRole entity);

    /**
     * queries转entities
     *
     * @param queries {@link CustomerRoleQuery}
     * @return entity对象 {@link CustomerRole}
     */
    List<CustomerRole> queriesToEntities(List<CustomerRoleQuery> queries);

    /**
     * query转entity
     *
     * @param query {@link CustomerRoleQuery}
     * @return entity对象 {@link CustomerRole}
     */
    CustomerRole queryToEntity(CustomerRoleQuery query);

}