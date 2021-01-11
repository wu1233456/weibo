package com.weibo.dao;

import com.weibo.bean.Comment;
import com.weibo.bean.News;

import java.util.List;

public class CommentDao extends BaseDao {

    public List<Comment> getlist(Integer newsId) {
        String sql = "select * from comment where newsId = ? ";
        return queryForList(Comment.class, sql,newsId);
    }

    public int  add(Comment comment) {
        String sql = "insert into comment(`content`,`newsId`,`name`) values(?,?,?)";
        return update(sql,comment.getContent(),comment.getNewsId(),comment.getName());
    }

}
