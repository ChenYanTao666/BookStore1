package com.yuchen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuchen.Utils.WEBUtils;
import com.yuchen.bean.Book;
import com.yuchen.bean.Page;
import com.yuchen.service.BookService;
import com.yuchen.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookClientServlet
 */
@WebServlet("/BookClientServlet")
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookServiceImpl();
	// 查询所有图书
	protected void getBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户传入的页码
				String pageNum = request.getParameter("pageNum");
				String pageSize = request.getParameter("pageSize");
				Page<Book> pageBook = bookService.getPageBook(pageNum, pageSize);
			    pageBook.setPath(WEBUtils.getPath(request, response));
				System.out.println(pageBook.toString());
				// 将books放到request域中
				request.setAttribute("books", pageBook);
	
		request.getRequestDispatcher("/pages/manager/bookHome.jsp").forward(request, response);
	}
	
	// 获取价格带分页的图书
	protected void getPageBooksByPrcie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户传入的页码
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		String minPrice = request.getParameter("minPrcie");
		String maxPrcie = request.getParameter("maxPrice");
		Page<Book> pageBook = bookService.getPageBooksByPrice(pageNum, pageSize, minPrice, maxPrcie);
	    pageBook.setPath(WEBUtils.getPath(request, response));
		System.out.println(pageBook.toString());
		// 将books放到request域中
		request.setAttribute("books", pageBook);
		request.getRequestDispatcher("/pages/manager/bookHome.jsp").forward(request, response);
	}
    
}
