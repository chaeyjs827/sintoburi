package com.sintoburi.member.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author seongnamfc
 * @package com.sintoburi.customer.dto
 * @file CustomerDto
 * @description
 * @date 2021/12/18
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDto {
    private Long id;
    private String memberId;
    private String memberStatusCode;
    private String password;
    private String email;
    private String nickname;
    private String name;
    private String phone;
    private String lastLoginAt;
    private Long isDormant;
    private Long agreementPrivacyId;
    private String registerDate;
    private String quitDate;
    private String lastPasswordChangeAt;
    private String createdAt;
    private String updatedAt;
}
