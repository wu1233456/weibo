package com.weibo.service;

import com.weibo.bean.News;
import com.weibo.dao.NewsDao;

import java.util.List;

public class NewsService {
    NewsDao newsDao=new NewsDao();

    public News get(Integer id){
        News news = newsDao.get(id);
        return news;
    }

   public List<News> getlist(){
       List<News> getlist = newsDao.getlist();
       return getlist;
   }

   public int add(News news){
       int res = newsDao.add(news);
       return res;
   }

   public void addCommentsNum(Integer newsId){
       News news = newsDao.get(newsId);
       Integer commentsNum = news.getCommentsNum();
       news.setCommentsNum(commentsNum+1);
       newsDao.update(news,newsId);
   }

}
