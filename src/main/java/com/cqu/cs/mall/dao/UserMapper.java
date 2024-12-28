package com.cqu.cs.mall.dao;

import com.cqu.cs.mall.domain.UserDO;
import com.cqu.cs.mall.dto.req.UserRegisterReqDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int register(UserDO userDO);

    UserDO selectByPhone(String phone);

    void update(UserDO userDO);
}