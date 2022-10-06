package com.pingyun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] urls = {"/login.jsp","/imgs/","/css/","/login","/register.jsp","/register",
                "/code", "/index.html"};
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURL().toString();
        for (String s : urls) {
            if (url.contains(s)) {
                filterChain.doFilter(request, servletResponse);
                return;
            }
        }
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.setAttribute("login_msg", "您尚未登录!");
            request.getRequestDispatcher("login.jsp").forward(request, servletResponse);
        }
    }

    public void destroy() {

    }
}
