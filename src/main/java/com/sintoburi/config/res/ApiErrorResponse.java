package com.sintoburi.config.res;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author seongnamfc
 * @package com.sintoburi.config.res
 * @file ApiResponse
 * @description
 * @date 2021/11/07
 */
@Getter
@ToString
@Builder
public class ApiErrorResponse<T> {

    private int code;
    private T data;

}
