package com.lxy.springbootdemo.dao;

import com.lxy.springbootdemo.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/7/22 23:17
 */
@Mapper
public interface IUserMapper {

    List<UserEntity> queryByLikeName(@Param(value = "name") String name);
}
