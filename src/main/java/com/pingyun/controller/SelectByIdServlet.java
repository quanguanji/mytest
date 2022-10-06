package com.pingyun.controller;

import com.pingyun.pojo.Brand;
import com.pingyun.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Brand brand = brandService.selectById(Integer.parseInt(id));
        request.setAttribute("brand", brand);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
