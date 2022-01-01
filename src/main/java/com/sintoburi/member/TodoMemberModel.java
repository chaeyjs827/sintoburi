package com.sintoburi.member;

import lombok.Data;

/**
 * @author seongnamfc
 * @package com.sintoburi.member
 * @file TodoMemberModel
 * @description
 * @date 2022/01/01
 */
@Data
public class TodoMemberModel {
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
