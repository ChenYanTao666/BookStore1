package com.yuchen.dao.impl;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yuchen.bean.Book;
import com.yuchen.bean.Page;
import com.yuchen.dao.BaseDao;
import com.yuchen.dao.BooksDao;

public class BookDaoLmpl extends BaseDao<Book> implements BooksDao {

	@Override
	public List<Book> getBooks() {
	    // 写sql 语句
		String sql = "select id,title,author,price,sales,stock,img_path imagePath from Books";
		List<Book> beanList = getBeanList(sql);
		return beanList;
	}
	
	//添加图书
	public void addBook(Book book){
		String  sql = "insert into Books(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
		update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImagePath());
	}
	// 删除图书
	public void deletBook(String id){
		String sql = "delete from Books where id = ?";
		update(sql, id);
	}

	@Override
	public void updataBook(Book book) {
		String  sql = "update Books set title = ?, author = ?, price = ?, sales= ? , stock =?, img_path = ?  where id = ?";
		update(sql, book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImagePath(),book.getId());
	}

	@Override
	public Book getBook(String id) {
		String sql = "select id,title,author,price,sales,stock,img_path imagePath from Books where id = ?";
		Book book = getBean(sql, id);
		return book;
	}

	@Override
	public Boolean haveBook(String id) {
		Book book = getBook(id);		
		if (book != null) {
			return true;
		}
		return false;
	}

	@Override
	public Page<Book> getPageBooks(Page<Book>page) {
	    //spl
	    String sql = "select count(*) from Books";
	    long singleValue = (long)getSingleValue(sql); //总记录数
	    page.setTotleSize((int)singleValue);
	    //查询
	    String sql1 = "select id,title,author,price,sales,stock,img_path imagePath from Books limit ?,?";
		List<Book> beanList = getBeanList(sql1,(page.getCurrentPage() - 1) * page.getPageSize(),page.getPageSize());
	    page.setList(beanList);
	    
		return page;
	}

	@Override
	public Page<Book> getPageBooksByPrice(Page<Book> page) {
		  //spl
	    String sql = "select count(*) from Books where price between ? and ?";
	    long singleValue = (long)getSingleValue(sql,page.getDefauleMinPrice(),page.getDefaultMaxPrice()); //总记录数
	    page.setTotleSize((int)singleValue);
	    //查询
	    String sql1 = "select id,title,author,price,sales,stock,img_path imagePath from Books where price between ? and ?  limit ?,?";
		List<Book> beanList = getBeanList(sql1,page.getDefauleMinPrice(),page.getDefaultMaxPrice(),(page.getCurrentPage() - 1) * page.getPageSize(),page.getPageSize());
	    page.setList(beanList);
	    
		return page;
	}

}
