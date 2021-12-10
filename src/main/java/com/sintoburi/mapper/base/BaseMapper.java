package com.sintoburi.mapper.base;

/**
 * @author seongnamfc
 * @package com.sintoburi.mapper.base
 * @file BaseMapper
 * @description
 * @date 2021/12/08
 */
public interface BaseMapper<D, E> {

    D toDto(E entity);
    E toModel(D dto);

}
