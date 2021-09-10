package com.wzq.ssmcrud.service;

import com.wzq.ssmcrud.bean.User;
import com.wzq.ssmcrud.bean.UserExample;
import com.wzq.ssmcrud.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 插入新的user
     * @param user
     * @return
     */
    public User insertUser(User user) {
        System.out.println("service层的user" + user);
        userMapper.insertSelective(user);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andEmailEqualTo(user.getEmail());
        List<User> users = userMapper.selectByExample(example);
        User newUser = null;
        try {
            newUser = users.get(0);
        } catch (Exception e) {
            newUser = null;
            System.out.println("插入失败");
        }
        return newUser;

    }


    /**
     * 检查用户名是否重复
     * @param username
     * @return
     */
    public User selectUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        User user = null;
        try {
            user = users.get(0);
        } catch (Exception e) {
            user = null;
        }
        System.out.println(user);
        return user;

    }

    /**
     * 登录验证
     * @param userName
     * @return
     */
    public User findUserByUsername(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(example);
        try {
            User user = users.get(0);
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
