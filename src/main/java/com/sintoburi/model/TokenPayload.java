package com.sintoburi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author seongnamfc
 * @package com.sintoburi.model
 * @file Payload
 * @description
 * @date 2021/11/14
 */
@Getter
@AllArgsConstructor
public class TokenPayload {
    private String at;
    private String rt;
    private String id;
    private Boolean isExpired;
    private String created_at;
    private String iat;
    private String exp;
}
