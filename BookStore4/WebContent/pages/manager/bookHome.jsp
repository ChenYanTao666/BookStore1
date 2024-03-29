<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@include file="/WEB-INF/incloud/base.jsp"%>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css">
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">网上书城</span>
		<div>
			<a href="pages/user/login.jsp">登录</a> | <a
				href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp; <a
				href="pages/cart/cart.jsp">购物车</a> <a
				href="pages/manager/manager.jsp">后台管理</a>
		</div>
	</div>

	<div id="main">
		<div id="book">
		<form action="BookClientServlet?method=getPageBooksByPrcie" method="post">
		<!--   <input type="hidden" name="method"  value="getPageBooksByPrcie"> -->
			<div class="book_cond">
				价格：<input type="text" name="minPrcie"> 元 - <input type="text"
					name="maxPrice"> 元
				<button type="submit">查询</button>
			</div>
					</form>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>

			<c:forEach items="${books.list}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="static/img/default.jpg" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span> <span class="sp2">${book.title}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span> <span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span> <span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span> <span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span> <span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button>加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>

	


	</div>
	
	<div id="bottom">
	   <%@ include file="/WEB-INF/incloud/page.jsp"%>
	   <br>
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>