package com.sintoburi.member.entity;

import lombok.Data;

/**
 * @author seongnamfc
 * @package com.sintoburi.customer.entity
 * @file CustomerEntity
 * @description
 * @date 2021/12/18
 */
@Data
public class MemberEntity {
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
