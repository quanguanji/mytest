package com.pingyun.controller;

import com.pingyun.pojo.User;
import com.pingyun.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        User user = userService.login(username, password);
        if (user != null) {
            if ("1".equals(remember)) {
                Cookie c_username = new Cookie("c_username", username);
                Cookie c_password = new Cookie("c_password", password);
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");
        } else {
            String msg = "用户名或密码错误";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
