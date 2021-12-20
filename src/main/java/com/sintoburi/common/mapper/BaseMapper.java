package com.sintoburi.common.mapper;

/**
 * @author seongnamfc
 * @package com.sintoburi.common.mapper
 * @file BaseMapper
 * @description
 * @date 2021/12/20
 */
public interface BaseMapper<D, E> {
    D toDto(E entity);
    E toModel(D dto);
}
