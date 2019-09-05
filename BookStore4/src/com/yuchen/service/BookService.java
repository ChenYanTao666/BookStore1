package com.yuchen.service;

import java.util.List;

import com.yuchen.bean.Book;
import com.yuchen.bean.Page;

public interface BookService {
	public List<Book> getBooks();
	public void addBookes(Book book);
	public void deletBook(String id);
	public void updateBook(Book book);
	public Book getBook(String id);
	public Boolean haveBook(String id);
	public Page<Book> getPageBook(String pageNo,String pageSize);
	public Page<Book> getPageBooksByPrice(String pageNo, String pageSize, String minPrice, String maxPrice);
}
