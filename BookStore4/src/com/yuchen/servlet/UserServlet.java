package com.yuchen.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.swing.internal.plaf.metal.resources.metal;
import com.yuchen.bean.User;
import com.yuchen.service.UserService;
import com.yuchen.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(0, username, password, null);
		UserService userService = new UserServiceImpl();
		User user1 =  userService.login(user);
		if (user1 != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/login_success.jsp");
	        requestDispatcher.forward(request, response);
		}else{
			// 设置错误消息放到 request 里面
		    request.setAttribute("name", username);
		    request.setAttribute("msg", "账号密码错误");
		    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/login.jsp");
		    requestDispatcher.forward(request, response);
		}

	}
	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User(0, username, password, email);
		UserService userService = new UserServiceImpl();
		boolean result = userService.regist(user);
		if (result) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist_success.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("msg", "注册失败");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}


