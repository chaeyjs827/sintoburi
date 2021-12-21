package com.sintoburi.member.service;

import com.sintoburi.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seongnamfc
 * @package com.sintoburi.customer.service
 * @file CustomerService
 * @description
 * @date 2021/12/18
 */

public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public String test() {
//        memberDao.getMemberById();
        return "test";
    }

}
