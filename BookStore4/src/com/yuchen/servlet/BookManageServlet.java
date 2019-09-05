package com.yuchen.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuchen.Utils.WEBUtils;
import com.yuchen.bean.Book;
import com.yuchen.bean.Page;
import com.yuchen.service.BookService;
import com.yuchen.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookManageServlet
 */
@WebServlet("/BookManageServlet")
public class BookManageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    BookService bookService = new BookServiceImpl();
    /**
     * @see BaseServlet#BaseServlet()
     */
    public BookManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    //  查询所有图书
	protected void getBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取所有的图书
		List<Book> books = bookService.getBooks();
		// 将books放到request域中
		request.setAttribute("books", books);
		// 转发到显示所有图书的页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	// 新增  图书
	protected void addBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取图书
	    String title = request.getParameter("book_name");
	    String price = request.getParameter("book_price");
	    String author = request.getParameter("book_author");
	    String sales = request.getParameter("book_sales");
	    String stock = request.getParameter("book_stock");
	    String id = request.getParameter("bookId");
	    System.out.println("id == "+ id);
	    Boolean haveBook = bookService.haveBook(id);
	    if (haveBook) {
	    	 // 更新
	    	  Book book = new Book( title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null);
	    	  book.setId(Integer.parseInt(id));
			  bookService.updateBook(book);
			     // 方式一：调用getBooks方法重新从数据库中获取所有图书的信息
			 getPageBooks(request, response);
		}else {
		    // 封装book 新增
		    Book book = new Book( title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null);
		    bookService.addBookes(book);
		      // 方式一：调用getBooks方法重新从数据库中获取所有图书的信息
		    getPageBooks(request, response);
		 	 // 方式二：重定向到BookManagerServlet中的getBooks方法
//		 	response.sendRedirect(request.getContextPath() + "/BookManagerServlet?method=getBooks");
		}

	}
	
	// 删除 图书
	protected void deletBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    System.out.println("sadasdasda");
		String id = request.getParameter("bookId");
		bookService.deletBook(id);
		getBooks(request, response);
	}
	
	// 更新 图书
	protected void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    System.out.println("sadasdasda");
		String id = request.getParameter("bookId");
		bookService.deletBook(id);
		getBooks(request, response);
	}
	// 获取一个图书
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("bookId");
		Book book = bookService.getBook(id);
		// 将books放到request域中
		request.setAttribute("book", book);
		// 转发到显示所有图书的页面
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	// 获取带分页的图书
	protected void getPageBooks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户传入的页码
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		Page<Book> pageBook = bookService.getPageBook(pageNum, pageSize);
	    pageBook.setPath(WEBUtils.getPath(request, response));
		System.out.println(pageBook.toString());
		// 将books放到request域中
		request.setAttribute("books", pageBook);
		// 转发到显示所有图书的页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
    

	
	

}
