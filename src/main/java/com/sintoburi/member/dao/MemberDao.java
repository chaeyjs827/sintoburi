package com.sintoburi.member.dao;

import com.sintoburi.member.entity.MemberEntity;

/**
 * @author seongnamfc
 * @package com.sintoburi.customer.dao
 * @file CustomerDao
 * @description
 * @date 2021/12/18
 */
public interface MemberDao {

    MemberEntity getMemberById(Long id);

}
