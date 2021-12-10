package com.sintoburi.dao;

import com.sintoburi.model.MemberModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author seongnamfc
 * @package com.sintoburi.dao
 * @file TestDao
 * @description
 * @date 2021/12/04
 */
@Mapper
public interface TestDao {

    MemberModel getTest();

}
