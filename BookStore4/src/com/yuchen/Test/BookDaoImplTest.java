package com.yuchen.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.yuchen.bean.Book;
import com.yuchen.bean.Page;
import com.yuchen.dao.BooksDao;
import com.yuchen.dao.impl.BookDaoLmpl;

public class BookDaoImplTest {
   BooksDao BookDao = new BookDaoLmpl();
//	@Test
//	public void test() {
//		List<Book> books = BookDao.getBooks();
//		for (Book book : books) {
//			System.out.println(book);
//		}
//	
//	}
//	@Test
//	public void textGetpageBook(){
//		Page<Book> page = BookDao.getPageBooks("asd", "10");
//		System.out.println(page.getTotleSize());
//	}

}
