package com.sintoburi.member.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sintoburi.member.validation.MemberValidation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "회원 번호를 입력 해주세요.", groups = {MemberValidation.GetMember.class})
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
