package com.fairychar.uaa.service.structure;


import com.fairychar.uaa.entity.Authority;
import com.fairychar.uaa.pojo.dto.AuthorityDTO;
import com.fairychar.uaa.pojo.query.AuthorityQuery;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * (Authority)表数据库实体转换器
 *
 * @author chiyo
 * @since 2021-02-08 17:38:27
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorityStructure {
    /**
     * entities转dtos
     *
     * @param entities {@link Authority}
     * @return dto对象 {@link AuthorityDTO}
     */
    List<AuthorityDTO> entitiesToDtos(List<Authority> entities);

    /**
     * entity转dto
     *
     * @param entity {@link Authority}
     * @return dto对象 {@link AuthorityDTO}
     */
    AuthorityDTO entityToDto(Authority entity);

    /**
     * queries转entities
     *
     * @param queries {@link AuthorityQuery}
     * @return entity对象 {@link Authority}
     */
    List<Authority> queriesToEntities(List<AuthorityQuery> queries);

    /**
     * query转entity
     *
     * @param query {@link AuthorityQuery}
     * @return entity对象 {@link Authority}
     */
    Authority queryToEntity(AuthorityQuery query);

}