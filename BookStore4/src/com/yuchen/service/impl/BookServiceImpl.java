package com.yuchen.service.impl;

import java.util.List;

import com.yuchen.bean.Book;
import com.yuchen.bean.Page;
import com.yuchen.dao.BooksDao;
import com.yuchen.dao.impl.BookDaoLmpl;
import com.yuchen.service.BookService;

public class BookServiceImpl implements BookService {
	BooksDao bookDaoLmpl = new BookDaoLmpl();
	@Override
	public List<Book> getBooks(){
		List<Book> books = bookDaoLmpl.getBooks();
		return books;
	}
	public void addBookes(Book book){
		bookDaoLmpl.addBook(book);
	}
	@Override
	public void deletBook(String id) {
	    bookDaoLmpl.deletBook(id);
	}
	@Override
	public void updateBook(Book book) {
		bookDaoLmpl.updataBook(book);
	}
	@Override
	public Book getBook(String id) {
		Book book = bookDaoLmpl.getBook(id);
		return book;
	}
	@Override
	public Boolean haveBook(String id) {
		if (id == null) {
			return false;
		}else {
			Boolean haveBook = bookDaoLmpl.haveBook(id);
			return haveBook;	
		}
	
	}
	@Override
	public Page<Book> getPageBook(String pageNo, String pageSize) {
		Page<Book> page = new Page<Book>();
		// 将页码设置到page
		int defaultPageNo = 1;
		int defaultPageSize = 10;
		if (pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == null) {
			pageSize = "10";
		}
		
		try {
			defaultPageNo = Integer.parseInt(pageNo);
			defaultPageSize = Integer.parseInt(pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    page.setCurrentPage(defaultPageNo);
	    page.setPageSize(defaultPageSize);
	    Page<Book> page2 = bookDaoLmpl.getPageBooks(page);
	    return page2;
	}
	@Override
	public Page<Book> getPageBooksByPrice(String pageNo, String pageSize, String minPrice, String maxPrice) {
		Page<Book> page = new Page<Book>();
		// 将页码设置到page
		int defaultPageNo = 1;
		int defaultPageSize = 10;
		double defauleMinPrice = 0;
		double defaultMaxPrice = Double.MAX_VALUE;
		if (pageNo == null) {
			pageNo = "1";
		}
		if (pageSize == null) {
			pageSize = "10";
		}
		try {
			defaultPageNo = Integer.parseInt(pageNo);
			defaultPageSize = Integer.parseInt(pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			defauleMinPrice = Double.parseDouble(minPrice);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			defaultMaxPrice = Double.parseDouble(maxPrice);
		} catch (Exception e) {
			// TODO: handle exception
		}
	    page.setCurrentPage(defaultPageNo);
	    page.setPageSize(defaultPageSize);
	    page.setDefauleMinPrice(defauleMinPrice);
	    page.setDefaultMaxPrice(defaultMaxPrice);
	    Page<Book> page2 = bookDaoLmpl.getPageBooksByPrice(page);
	    return page2;
	}

}
