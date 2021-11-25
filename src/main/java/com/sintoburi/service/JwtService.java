package com.sintoburi.service;

import com.sintoburi.dto.auth.JwtDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author seongnamfc
 * @package com.sintoburi.service
 * @file JwtService
 * @description
 * @date 2021/11/23
 */
public interface JwtService {
    public String getJwtFromRequest(HttpServletRequest request);

    public JwtDto parsedJwt(String jwt);

    public Boolean checkJwtValid(String jwt, String authRole);

    public String refreshJwt(String jwt);

}
