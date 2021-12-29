package com.sintoburi.member.dao;

import com.sintoburi.member.entity.TodoMemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author seongnamfc
 * @package com.sintoburi.customer.dao
 * @file CustomerDao
 * @description
 * @date 2021/12/18
 */
@Mapper
public interface MemberDao {

    TodoMemberEntity getMemberById(Long id);

}
