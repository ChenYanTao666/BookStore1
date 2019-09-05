package com.yuchen.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取method
		String methodName = request.getParameter("method");
		System.out.println("进get了" + methodName);
		try {
			// 1.获取方法对象
			// getDeclaredMethod()方法中需要两个参数
			// 第一个参数是要调用的方法的方法名；第二个参数是要调用的方法的参数的类型
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 2.设置访问权限
			method.setAccessible(true);
			// 3.调用方法
			// invoke()方法也需要传入两个参数
			// 第一个参数是要调用那个对象的方法；第二个参数是要调用的方法中需要传入的参数
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进post了");
		doGet(request, response);
	}

}
