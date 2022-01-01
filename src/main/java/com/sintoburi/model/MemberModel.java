package com.sintoburi.model;

import lombok.Data;

@Data
public class MemberModel {
    private Long id;
    private String memberLoginId;
    private String memberStatusCode;
    private String password;
    private String email;
    private String nickname;
    private String name;
    private String phone;
    private Long isDormant;
    private Long agreementPrivacyId;
    private String registerDate;
    private String quitDate;
    private String lastLoginDate;
    private String lastPasswordChangeDate;
    private String createdDate;
    private String updatedDate;
}
