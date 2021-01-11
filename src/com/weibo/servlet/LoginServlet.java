package com.weibo.servlet;

import com.alibaba.fastjson.JSON;
import com.weibo.bean.User;
import com.weibo.eenum.ErrorCodeEnum;
import com.weibo.service.UserService;
import com.weibo.utils.ResultBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("fanwenwola");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(ResultBean.OK));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password = req.getParameter("password");
        User login = userService.login(username, password);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        if (login==null){
            resp.getWriter().write(JSON.toJSONString(new ResultBean(ErrorCodeEnum.LOGIN_FAIL)));
        }else {
            Integer id = login.getId();
            Map<String,Object> data=new HashMap<>();
            data.put("userId",id);
            resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
        }
    }



}