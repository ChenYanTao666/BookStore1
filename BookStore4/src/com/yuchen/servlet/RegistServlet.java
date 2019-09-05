package com.yuchen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuchen.bean.User;
import com.yuchen.service.UserService;
import com.yuchen.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
