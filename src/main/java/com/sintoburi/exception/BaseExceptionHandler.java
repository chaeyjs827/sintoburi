package com.sintoburi.exception;

import com.sintoburi.config.res.ApiErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author seongnamfc
 * @package com.sintoburi.exception
 * @file BaseExceptionHandler
 * @description
 * @date 2021/11/07
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(ExpiredJwtException.class)
    protected ResponseEntity<ApiErrorResponse> handleExpiredJwtException(ExpiredJwtException e) {
        return ResponseEntity
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiErrorResponse.builder()
                        .code(Integer.parseInt(ErrorCode.INTERNAL_SERVER_ERROR.getCode()))
                        .data(e.getMessage())
                        .build());
    }
}
