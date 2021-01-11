package com.weibo.servlet;

import com.alibaba.fastjson.JSON;
import com.weibo.bean.News;
import com.weibo.bean.User;
import com.weibo.eenum.ErrorCodeEnum;
import com.weibo.service.NewsService;
import com.weibo.service.UserService;
import com.weibo.utils.ResultBean;
import com.weibo.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/news/*")
public class NewsServlet  extends BaseServlet {

    private NewsService newsService=new NewsService();
    private UserService userService=new UserService();

    public void getlist(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        List<News> list = newsService.getlist();
        Map<String,Object> data=new HashMap<>();
        data.put("list",list);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
    }

    public void getdetail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        News news = newsService.get(id);

        Map<String,Object> data=new HashMap<>();
        data.put("news",news);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String content=req.getParameter("content");
        int userId = WebUtils.parseInt(req.getParameter("userId"), 0);

        //根据用户id查找用户名
        User user = userService.get(userId);
        System.out.println("保存时查到的用户信息");
        System.out.println(user);
        //发布时间
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd/HH:mm:ss");
        String date = sdf.format(new Date());

        News news = new News();
        news.setContent(content);
        news.setNewswriter(user.getUsername());
        news.setTime(date);
        news.setUserId(userId);

        System.out.println(news);
        newsService.add(news);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(ResultBean.OK));
    }

}
