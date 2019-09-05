package com.yuchen.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yuchen.bean.Book;
import com.yuchen.bean.Page;
import com.yuchen.service.BookService;
import com.yuchen.service.impl.BookServiceImpl;
import com.yuchen.servlet.BookManageServlet;

public class BookManageServletTest extends BookManageServlet {

	@Test
	public void test() {
	BookService bookService2 = new BookServiceImpl();
	Page<Book> books = bookService2.getPageBook("A", "s");
	System.out.println(books.toString());
	}

}
