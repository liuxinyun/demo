package com.lxy.springbootdemo.service.impl;

import com.lxy.springbootdemo.dao.IUserMapper;
import com.lxy.springbootdemo.model.UserEntity;
import com.lxy.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/7/30 23:13
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<UserEntity> queryLikeByName(String name) {
        return userMapper.queryByLikeName(name);
    }
}
