package com.fairychar.uaa.service.structure;


import com.fairychar.uaa.entity.OrganizationCustomer;
import com.fairychar.uaa.pojo.dto.OrganizationCustomerDTO;
import com.fairychar.uaa.pojo.query.OrganizationCustomerQuery;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * (OrganizationCustomer)表数据库实体转换器
 *
 * @author chiyo
 * @since 2021-02-08 17:38:41
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrganizationCustomerStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link OrganizationCustomer}
     * @return dto对象 {@link OrganizationCustomerDTO}
     */
    List<OrganizationCustomerDTO> entitiesToDtos(List<OrganizationCustomer> entities);

    /**
     * entity转dto
     *
     * @param entity {@link OrganizationCustomer}
     * @return dto对象 {@link OrganizationCustomerDTO}
     */
    OrganizationCustomerDTO entityToDto(OrganizationCustomer entity);

    /**
     * queries转entities
     *
     * @param queries {@link OrganizationCustomerQuery}
     * @return entity对象 {@link OrganizationCustomer}
     */
    List<OrganizationCustomer> queriesToEntities(List<OrganizationCustomerQuery> queries);

    /**
     * query转entity
     *
     * @param query {@link OrganizationCustomerQuery}
     * @return entity对象 {@link OrganizationCustomer}
     */
    OrganizationCustomer queryToEntity(OrganizationCustomerQuery query);

}