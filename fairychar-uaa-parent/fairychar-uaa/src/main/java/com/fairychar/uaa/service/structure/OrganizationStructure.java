package com.fairychar.uaa.service.structure;


import com.fairychar.uaa.entity.Organization;
import com.fairychar.uaa.pojo.dto.OrganizationDTO;
import com.fairychar.uaa.pojo.query.OrganizationQuery;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * (Organization)表数据库实体转换器
 *
 * @author chiyo
 * @since 2021-02-08 17:38:38
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrganizationStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link Organization}
     * @return dto对象 {@link OrganizationDTO}
     */
    List<OrganizationDTO> entitiesToDtos(List<Organization> entities);

    /**
     * entity转dto
     *
     * @param entity {@link Organization}
     * @return dto对象 {@link OrganizationDTO}
     */
    OrganizationDTO entityToDto(Organization entity);

    /**
     * queries转entities
     *
     * @param queries {@link OrganizationQuery}
     * @return entity对象 {@link Organization}
     */
    List<Organization> queriesToEntities(List<OrganizationQuery> queries);

    /**
     * query转entity
     *
     * @param query {@link OrganizationQuery}
     * @return entity对象 {@link Organization}
     */
    Organization queryToEntity(OrganizationQuery query);

}