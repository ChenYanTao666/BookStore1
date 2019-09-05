package com.yuchen.dao;

import java.util.List;

import com.yuchen.bean.Book;
//  先创建一个接口  在去实现
import com.yuchen.bean.Page;
public interface BooksDao {
	/*
	 * 获取所有的图书
	 */
	public List<Book> getBooks();
    
	//添加图书
	public void addBook(Book book);
	
	//删除图书
    public void deletBook(String id);
    
    //更新图书
    public void updataBook(Book book);
    
    //获取某个图书信息
    public Book getBook(String id);
    
    //是否存在图书
    public Boolean haveBook(String id);

    //获取分页
    public Page<Book> getPageBooks(Page<Book>page);
    
    //按着价格查询
    public Page<Book> getPageBooksByPrice(Page<Book>page);
	
}
