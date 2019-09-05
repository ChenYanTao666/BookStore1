<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function buttonAction() {
		alert("adsda");
		$
		window.open("test3.jsp")
	}
</script>
</head>
<body>
	<h1>我是第二个测试页面的</h1>
	<h2><%=request.getParameter("name")%></h2>
	<!-- JSP 9大隐含对象 -->
	<!--即不用声明就可以用（因为在对应的jspService()页面中已经声明了）
	 pageContext   javax.servlet.jsp.PageContext:
	 requset  HttpServletRequest和Servlet中的request作用一样，它是一个域对象
	 session  HttpSesion 它是一个域对象
	 application SevletContent 
	 response HttpServletResponse 和servlet的response作用一样 在jsp中基本不用
	 config  类型servletConfig 
	 作用 获取jsp的初始化参数
	 out jspWriter 
	 和printWriter作用一样，可以给浏览器一个响应
	 page 相当于this 
	 exception throwable 获取异常信息 前提是isErrorPage 为true 才有用
	-->

	<!-- 域 在javaWeb中指不同的Web资源（html jsp sevlet）
	不同的web资源需要同享数据，就有了域对象 
	javaWeb中有四个域对象，分别是 pageContext request seesion application
	四个域对象有一下三个方法
	向域中添加属性
	.void setAttribute(String key,Object value)
	根据属性名获取属性值
	Objcet getAttribute(String key)
	移除属性
	void removeAttribute(String key)
	
	四个域
	。page域
	当前页面对应的对象 pageContent 
	。request 
	当前请求（一次请求）
	对应对象 request
	。seesion
    范围 当前会话	
    对应对象 seesion
    
    application 
    当前应用
    对象 application
    
	四个域的使用规则  能用小的不用大的
	
	-->
	<%
		pageContext.setAttribute("pagekey", "pageValue");
		session.setAttribute("sessionkey", "sessionValue");
		request.setAttribute("requestKey", "requestValue");
		application.setAttribute("applicationkey", "applicationValue");
	%>
	<h1>获取四个属性值</h1>

	page中的属性值<%=pageContext.getAttribute("pagekey")%>
	<br>
	<br> session中的属性值<%=session.getAttribute("sessionkey")%>
	<br>
	<br> request中的属性值<%=request.getAttribute("requestKey")%>
	<br>
	<br> application中的属性值<%=application.getAttribute("applicationkey")%>
	<br>
	<br>
    <a href="test3.jsp">test4</a> <br>
	<button onclick="buttonAction()">点击跳转</button>

</body>
</html>