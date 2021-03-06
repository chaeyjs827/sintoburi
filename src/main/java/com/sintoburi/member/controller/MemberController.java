package com.sintoburi.member.controller;

import com.sintoburi.member.dto.TodoMemberDto;
import com.sintoburi.member.service.MemberService;
import com.sintoburi.member.validation.MemberValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seongnamfc
 * @package com.sintoburi.customer.controller
 * @file CustomerController
 * @description
 * @date 2021/12/18
 */
@RestController
@RequestMapping(value = "/customer")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(value = "/test")
    public String test(@Validated(MemberValidation.GetMemberList.class) TodoMemberDto todoMemberDto) {
        return memberService.test();
    }

//    @GetMapping(value = "/test")
//    @Validated(MemberValidation.GetMemberList.class)
//    public String test(MemberDto memberDto) {
//        return memberService.test();
//    }
}
