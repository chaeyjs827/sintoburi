package com.sintoburi.service.impl;

/**
 * @author seongnamfc
 * @package com.sintoburi.service.impl
 * @file LegacyRedisService
 * @description
 * @date 2021/12/01
 */
public interface LegacyRedisService {

   public void save(String cacheName, Object key, Object data);

}
