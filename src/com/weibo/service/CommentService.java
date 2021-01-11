package com.weibo.service;

import com.weibo.bean.Comment;
import com.weibo.dao.CommentDao;

import java.util.List;

public class CommentService {

   private CommentDao commentDao=new CommentDao();


   public List<Comment> getlist(Integer newsId){
       List<Comment> list = commentDao.getlist(newsId);
       return list;
   }

   public void add(Comment comment){
       int add = commentDao.add(comment);
   }

}
