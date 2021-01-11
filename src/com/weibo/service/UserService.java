package com.weibo.service;

import com.weibo.bean.User;
import com.weibo.dao.UserDao;

public class UserService {

    UserDao userDao=new UserDao();

    /**
     * 登录
     *
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(String username,String password) {
        User res = userDao.get(username,password);
        return res;
    }

    public User get(Integer id){
        User user = userDao.get(id);
        return user;
    }


}
