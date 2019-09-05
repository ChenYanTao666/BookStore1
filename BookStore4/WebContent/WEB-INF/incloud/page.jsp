<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="page_nav">
			<a href="${books.path}&pageNum=1">首页</a>
			<c:if test="${books.currentPage >1}">
				<a href="${books.path}&pageNum=${books.currentPage-1}">上一页</a>
			</c:if>
			<!-- 当总页数小于五 -->
			<!-- 当总页数大于五 当前页数小于3 -->
			<!-- 当前也数大于5 当前页数大于3 -->
			<c:choose>
				<c:when test="${books.totlePageNo < 5}">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${books.totlePageNo}"></c:set>
				</c:when>
				<c:when test="${books.currentPage <= 3}">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="5"></c:set>
				</c:when>
				<c:when test="${books.currentPage + 2 > books.totlePageNo }">
					<c:set var="begin" value="${books.totlePageNo - 4}"></c:set>
					<c:set var="end" value="${books.totlePageNo}"></c:set>
				</c:when>

				<c:otherwise>
					<c:set var="begin" value="${books.currentPage - 2}"></c:set>
					<c:set var="end" value="${books.currentPage + 2}"></c:set>
				</c:otherwise>
			</c:choose>

			<c:forEach begin="${begin}" end="${end}" var="index">
				<c:if test="${index == books.currentPage}">
					<a href="${books.path}&pageNum=${index}">【${index}】</a>
				</c:if>
				<c:if test="${index != books.currentPage}">
					<a href="${books.path}&pageNum=${index}">${index}</a>
				</c:if>
			</c:forEach>
			<c:if test="${books.currentPage < books.totlePageNo}">
				<a
					href="${books.path}&pageNum=${books.currentPage+1}">下一页</a>
				<a
					href="${books.path}&pageNum=${books.totlePageNo}">末页</a>
			</c:if>
			共${books.totlePageNo}页，${books.totleSize}条记录 到第<input value="1"
				name="pn" id="pn_input" />页 <input type="button" value="确定"
				class="goButton">
		</div>