<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="false"
	isELIgnored="false" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--就是在<>中写java代码 -->
	<%
		Date date = new Date();
		// 将时间显示到浏览器
		for (int i = 0; i < 10; i++) {
			out.print("你是王");
	%>
	<h1 style="color: red;">你是王</h1>
	<%
		}
	%>
	<!-- JSP表达式 -->
	<!-- page指令 用来告诉服务器如何解析当前页面 -->
	<!-- language属性：用来指定当前页面使用的编程语言，默认值是java 可选值也是java 也就是说该属性只有一个java 
	     conrentType属性：用来告诉浏览器使用什么字符集来解码当前页面
	     pageEncoding属性:用来设置当前页面使用的字符集
	     errorPage 属性: 用来设置当前页面出现异常时要转发到的页面
	     isErrorPage :当前页面是否是错误页面
	     import：导包
	     isELIgnored: 还否忽略el表达式 
	     session:当前页面中是否可以使用session 对象
	-->
	<!-- include 指令
	
	 -->
	<%@ include file="test2.jsp"%>

	<%
		/*
		* 这是java的多行注释
		*/
		Date data = new Date();
	%>
	<h1>
		现在的时间是:
		<%=date%>点
	</h1>
	<!-- JSP 常用的标签 -->
	<!-- forward 标签：用来进行请求的转发 -->
	<!-- page属性：用来设置要转发的页面的地址 -->
	<%-- <jsp:forward page="test2.jsp"></jsp:forward> --%>
	<!-- 带请求参数 -->
	<!-- 如果在转发的时候没有携带参数，转发的标签提中不能包含任何内容 -->
	<jsp:forward page="test2.jsp">
		<jsp:param value="yuchen" name="name" />
		<jsp:param value="123456" name="password" />
	</jsp:forward>
	

	<!-- incloud 页面 包含上面的是静态包含 -->
	<!-- 1.静态包含值翻译，编译包含页面，不翻译，编译被包含的页面。动态包含即翻译，翻译包含页面又翻译，翻该包含的页面 
	     2.如果被包含的页面是一个静态页面，我们通常使用静态包含，如果被包含的页面是一个动态 页面我们通常使用动态包含
	 -->
	
	<!--
	  JSP 用来显示页面  servlet 用来显示处理请求
	
	  -->
	
	
	
	<jsp:include page="test2.jsp"></jsp:include>
	
	
</body>
</html>