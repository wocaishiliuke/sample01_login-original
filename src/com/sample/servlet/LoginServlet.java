package com.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.domain.User;
import com.sample.service.UserService;

//@WebServlet(description="登陆servlet", urlPatterns="/login/*")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserService userService = new UserService();
		User existUser = userService.login(user);
		
		resp.setContentType("text/html;charset=utf-8");
		if (null == existUser) {
			resp.getWriter().print("<font color='green'>登陆成功<font/>");
		}else {
			resp.getWriter().print("<font color='red'>登陆失败<font/>");
		}
	}
	
}
