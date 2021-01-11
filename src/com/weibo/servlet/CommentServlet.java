package com.weibo.servlet;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.bind.v2.TODO;
import com.weibo.bean.Comment;
import com.weibo.bean.User;
import com.weibo.service.CommentService;
import com.weibo.service.NewsService;
import com.weibo.service.UserService;
import com.weibo.utils.ResultBean;
import com.weibo.utils.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/comment/*")
public class CommentServlet extends BaseServlet{

    private CommentService commentService=new CommentService();
    private UserService userService=new UserService();
    private NewsService newsService=new NewsService();

    /**
     * 通过新闻id获取全部的评论
     * @param req
     * @param resp
     * @throws IOException
     */
    public void getlist(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        List<Comment> comments = commentService.getlist(id);

        Map<String,Object> data=new HashMap<>();
        data.put("comments",comments);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
    }


    public void save(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        String content=req.getParameter("content");
        int userId = WebUtils.parseInt(req.getParameter("userId"), 0);
        int newsId = WebUtils.parseInt(req.getParameter("newsId"), 0);

        //根据用户id查找用户名
        User user = userService.get(userId);

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setName(user.getUsername());
        comment.setNewsId(newsId);

        commentService.add(comment);
        //TODO 同时还要向对应的新闻增加评论的数

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(ResultBean.OK));
    }
}
