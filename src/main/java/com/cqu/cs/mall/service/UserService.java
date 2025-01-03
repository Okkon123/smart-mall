package com.cqu.cs.mall.service;

import com.cqu.cs.mall.domain.UserDO;
import com.cqu.cs.mall.dto.req.UserLoginReqDTO;
import com.cqu.cs.mall.dto.req.UserRegisterReqDTO;
import com.cqu.cs.mall.dto.req.UserUpdateReqDTO;
import com.cqu.cs.mall.dto.resp.UserLoginRespDTO;

import java.util.List;

public interface UserService {
    void register(UserRegisterReqDTO userRegisterReqDTO);

    UserLoginRespDTO login(UserLoginReqDTO userLoginReqDTO);

    void update(UserUpdateReqDTO userUpdateReqDTO);

    void saveUserBatch(List<UserDO> cachedList);
}
