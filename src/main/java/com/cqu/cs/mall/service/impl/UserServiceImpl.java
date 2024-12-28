package com.cqu.cs.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.cqu.cs.mall.context.BaseContext;
import com.cqu.cs.mall.convention.exception.ClientException;
import com.cqu.cs.mall.convention.exception.ServiceException;
import com.cqu.cs.mall.dao.UserMapper;
import com.cqu.cs.mall.domain.UserDO;
import com.cqu.cs.mall.dto.req.UserLoginReqDTO;
import com.cqu.cs.mall.dto.req.UserRegisterReqDTO;
import com.cqu.cs.mall.dto.req.UserUpdateReqDTO;
import com.cqu.cs.mall.dto.resp.UserLoginRespDTO;
import com.cqu.cs.mall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import static com.cqu.cs.mall.convention.errorcode.BaseErrorCode.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public void register(UserRegisterReqDTO userRegisterReqDTO) {
        if (hasPhone(userRegisterReqDTO.getPhone())) {
            throw new ClientException(USER_PHONE_EXIST_ERROR);
        }
        UserDO userDO = BeanUtil.toBean(userRegisterReqDTO, UserDO.class);
        int num = userMapper.register(userDO);
        if (num != 1) {
            throw new ServiceException(USER_REGISTER_ERROR);
        }
    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO userLoginReqDTO) {
        if (!hasPhone(userLoginReqDTO.getPhone())) {
            throw new ClientException(USER_NOT_EXIST_ERROR);
        }
        String password = userMapper.selectByPhone(userLoginReqDTO.getPhone()).getPassword();
        if (!StringUtils.equals(password, userLoginReqDTO.getPassword())) {
            throw new ClientException(PASSWORD_WRONG_ERROR);
        }
        return new UserLoginRespDTO().setToken(userLoginReqDTO.getPhone());
    }

    @Override
    public void update(UserUpdateReqDTO userUpdateReqDTO) {
        String phone = BaseContext.getCurrentToken();
        UserDO userDO = BeanUtil.toBean(userUpdateReqDTO, UserDO.class);
        userDO.setPhone(phone);
        userMapper.update(userDO);
    }

    private boolean hasPhone(String phone) {
        UserDO userDO = userMapper.selectByPhone(phone);
        return userDO != null;
    }
}
