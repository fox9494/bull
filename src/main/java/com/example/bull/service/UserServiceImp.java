package com.example.bull.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bull.domain.User;
import com.example.bull.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp {

    @Autowired
    private UserMapper userMapper;


    public User findByName(String name){
        return userMapper.selectOne(new QueryWrapper<User>().eq("name",name));
    }


    @Transactional
    public int update(Long id,int age){
        User user = new User();
        user.setId(id);
        user.setName("chenlile");
        user.setAge(age);
        return userMapper.updateById(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateby(Long id,int age){
        User user = new User();
        user.setId(id);
        user.setName("chenlile");
        user.setAge(age);
        return userMapper.updateById(user);
    }
}
