package com.sintoburi.model;

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
public class JwtToken {
    private TokenHeader header;
    private TokenPayload payload;
    private String verifySignature;
}