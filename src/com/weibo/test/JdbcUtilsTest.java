package com.weibo.test;

import com.weibo.bean.News;
import com.weibo.bean.User;
import com.weibo.dao.UserDao;
import com.weibo.service.NewsService;
import com.weibo.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class JdbcUtilsTest {

    UserDao userDao=new UserDao();

    NewsService newsService=new NewsService();
    @Test
    public void testJdbcUtils(){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
    }

    @Test
    public void testDao(){

    }

    @Test
    public void testlist(){
        List<News> getlist = newsService.getlist();
        System.out.println(getlist);
    }

}
