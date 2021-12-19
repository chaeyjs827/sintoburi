package com.sintoburi.model;

import lombok.Data;

@Data
public class MemberModel {
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
