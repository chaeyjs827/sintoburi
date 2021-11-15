package com.sintoburi.config.res;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author seongnamfc
 * @package com.sintoburi.config.res
 * @file ApiResponse
 * @description
 * @date 2021/11/07
 */
@Data
@Builder
public class ApiResponse<T> {

    @Builder.Default
    private int code = HttpStatus.OK.value();

    @Builder.Default
    private String message="";

    private T data;

}
