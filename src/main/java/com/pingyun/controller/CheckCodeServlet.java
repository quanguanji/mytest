package com.pingyun.controller;

import com.pingyun.util.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/code")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream os = response.getOutputStream();
        String verifyCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);
        HttpSession session = request.getSession();
        session.setAttribute("code", verifyCode);
        System.out.println(verifyCode);
    }
}
