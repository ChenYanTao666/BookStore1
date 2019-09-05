<%@page import="com.yuchen.bean.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="True"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css">
<%@ include file="/WEB-INF/incloud/base.jsp"%>
<script type="text/javascript">
	$(function() {
		//给所有的删除绑定事件
		$(".deB").click(function() {
			// 取消默认行为
			/*   var title = $(this).parents('tr').children(":first").text();  
			  var title = $(this).parents('tr').find('td:firsrt').text(); */
			var title = $(this).attr("id");
			var flag = confirm("确定要删除【" + title + "】这本图书吗？");
			if (flag) {
				return true;
			}
			return false;
		});

		$(".goButton")
				.click(
						function() {
							var num = $("#pn_input").attr('value');
							// 发请求  重定向
							location.href = "BookManageServlet?method=getPageBooks&pageNum="
									+ num;
						});

	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif"> <span
			class="wel_word">图书管理系统</span>
		<%@ include file="/WEB-INF/incloud/header.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${books.list}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a
						href="BookManageServlet?method=getBook&bookId=${book.id}">修改</a></td>
					<td><a class="deB"
						href="BookManageServlet?method=deletBook&bookId=${book.id}"
						id=${book.title}>删除</a></td>
				</tr>

			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>
		<%-- 	  <div id="page_nav">
			 <a href="BookManageServlet?method=getPageBooks&pageNum=1">首页</a>
			 <c:if test="${books.currentPage >1}">
			  <a href="BookManageServlet?method=getPageBooks&pageNum=${books.currentPage-1}" >上一页</a> 
			  <a href="BookManageServlet?method=getPageBooks&pageNum=${books.currentPage-1}">${books.currentPage -1}</a> 
			 </c:if>
			 【${books.currentPage}】
			 <c:if test="${books.currentPage < books.totlePageNo}">
			 	<a href="BookManageServlet?method=getPageBooks&pageNum=${books.currentPage+1}"">${books.currentPage+1}</a> 
			  <a href="BookManageServlet?method=getPageBooks&pageNum=${books.currentPage+1}">下一页</a>
			  <a href="BookManageServlet?method=getPageBooks&pageNum=${books.totlePageNo}">末页</a> 
			 </c:if>
			  共${books.totlePageNo}页，${books.totleSize}条记录 
			  到第<input value="1" name="pn" id="pn_input" />页 <input type="button"
				value="确定" class="goButton">
		</div>  --%>

		<%@ include file="/WEB-INF/incloud/page.jsp"%>



	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>