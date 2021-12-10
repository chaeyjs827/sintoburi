package com.sintoburi.service.impl;

/**
 * @author seongnamfc
 * @package com.sintoburi.service.impl
 * @file StRedisService
 * @description
 * @date 2021/12/01
 */
public interface StRedisService {

   public void save(String cacheName, Object key, Object data);

}
