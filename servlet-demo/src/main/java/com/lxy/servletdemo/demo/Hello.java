package com.lxy.servletdemo.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liuxinyun
 * @date 2019/7/7 20:25
 */
@WebServlet("/hello")
public class Hello extends HttpServlet {

    private static final long serialVersionUID = -5314308138766166860L;


    private String message;

    @Override
    public void init() {
        System.out.println("servlet初始化……");
        message = "Hello World , Nice To Meet You: " + System.currentTimeMillis();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置响应内容类型
        response.setContentType("text/html");

        //设置逻辑实现
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁！");
    }

}
