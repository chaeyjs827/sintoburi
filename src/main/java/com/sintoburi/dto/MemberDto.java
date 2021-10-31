package com.sintoburi.dto;

import java.time.LocalDateTime;

import com.sintoburi.entity.MemberEntity;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class MemberDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
