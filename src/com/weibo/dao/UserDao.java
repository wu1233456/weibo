package com.weibo.dao;

import com.weibo.bean.User;

public class UserDao extends BaseDao{
    public User get(Integer id) {
        String sql = "select `id`,`username`,`password` from users where id = ?";
        return queryForOne(User.class, sql, id);
    }

    public User get(String username, String password) {
        String sql = "select `id`,`username`,`password` from users where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    public int save(User user) {
        String sql = "insert into users(`username`,`password`) values(?,?)";
        return update(sql, user.getUsername(),user.getPassword());
    }
}
