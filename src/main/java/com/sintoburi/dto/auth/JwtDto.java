package com.sintoburi.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author seongnamfc
 * @package com.sintoburi.model
 * @file Jwt
 * @description
 * @date 2021/11/14
 */
@Getter
@AllArgsConstructor
public class JwtDto {
    private JwtHeaderDto header;
    private JwtPayloadDto payload;
    private String verifySignature;
}