package com.weibo.dao;

import com.weibo.bean.News;
import com.weibo.bean.User;

import java.util.List;

public class NewsDao extends BaseDao{
    public News get(Integer id) {
        String sql = "select * from news where id = ?";
        return queryForOne(News.class, sql, id);
    }

    public List<News> getlist() {
        String sql = "select * from news ";
        return queryForList(News.class, sql);
    }

    public int  add(News news) {
        String sql = "insert into news(`content`,`userId`,`time`,`newswriter`) values(?,?,?,?)";
        return update(sql,news.getContent(),news.getUserId(),news.getTime(),news.getNewswriter());
    }

    public int update(News news,Integer id){
        String sql = "update news set `content` = ?,`userId` = ?,`time` = ?,`commentsNum`=? where `id`=?";
        return update(sql,news.getContent(),news.getUserId(),news.getTime(),news.getCommentsNum(),id);
    }
}
