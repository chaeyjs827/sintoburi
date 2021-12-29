package com.sintoburi.member.service;

import com.sintoburi.member.dao.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Slf4j
@Service
public class MemberService {

//    @Autowired
//    private MemberDao memberDao;

    public String test() {
//        memberDao.getMemberById();
        return "test";
    }

}
