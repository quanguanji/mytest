package com.pingyun.controller;

import com.pingyun.pojo.User;
import com.pingyun.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        HttpSession session = request.getSession();
        String code = (String)session.getAttribute("code");
        if (!checkCode.equals(code)) {
            request.setAttribute("register_msg", "验证码错误,请重新输入");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        boolean flag = userService.register(user);
        if (flag) {
            request.setAttribute("register_msg", "注册成功!请登录");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("register_msg", "用户名已存在");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
