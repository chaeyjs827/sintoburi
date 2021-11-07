package com.sintoburi.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author seongnamfc
 * @package com.sintoburi.exception
 * @file ErrorCode
 * @description
 * @date 2021/11/07
 */
@Getter
@ToString
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", HttpStatus.INTERNAL_SERVER_ERROR.name());

    private HttpStatus status;
    private String message;
    private String code;

    ErrorCode(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
