package com.lxy.springbootdemo.service;

import com.lxy.springbootdemo.model.UserEntity;

import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/7/30 23:13
 */
public interface IUserService {

    List<UserEntity> queryLikeByName(String name);

}
