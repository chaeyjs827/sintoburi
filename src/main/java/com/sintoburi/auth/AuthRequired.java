package com.sintoburi.auth;

import java.lang.annotation.*;

/**
 * @author seongnamfc
 * @package com.sintoburi.auth
 * @file AuthRequired
 * @description : 권한/인증 검증이 필요한 컨트롤러의 메소드에 사용함
 * @date 2021/11/05
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthRequired {

}
