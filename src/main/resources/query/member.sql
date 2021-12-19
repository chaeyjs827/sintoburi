create table member
(
    id                     bigint unsigned auto_increment primary key,
    member_id            varchar(20)                   not null comment '회원 ID',
    member_status_code   varchar(50)                   not null comment '상태 코드',
    password               varchar(255)                  not null comment '비밀번호',
    email                  varchar(255)                  not null comment '이메일',
    nickname                   varchar(100)                  null comment '닉네임',
    name                   varchar(50)                   not null comment '이름',
    phone                  varchar(20)                   not null comment '전화번호',
    last_login_at             datetime                      null comment '마지막 로그인 일시',
    is_dormant          smallint unsigned default '0' not null comment '휴면 계정 여부',
    agreement_privacy_id   bigint unsigned               null comment '가입 정책 동의',
    register_date              datetime                      null comment '가입 일시',
    quit_date               datetime                      null comment '탈퇴 일시',
    last_password_change_at     datetime                      null comment '비밀번호 변경 일시',
    created_at             timestamp                     null,
    updated_at             timestamp                     null
)
