package com.sintoburi.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author seongnamfc
 * @package com.sintoburi.model
 * @file Header
 * @description
 * @date 2021/11/14
 */
@Getter
@AllArgsConstructor
public class JwtHeaderDto {
    private String typ;
}
