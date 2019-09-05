package com.yuchen.bean;

public class Book {
   private Integer id;
   private String  title;
   private String  author;
   private double  price;
   private Integer sales;
   private Integer  stock;
   private String  imagePath;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}

public Book() {
	super();
}

public Book( String title, String author, double price, Integer sales, Integer stock, String imagePath) {
	super();
	this.title = title;
	this.author = author;
	this.price = price;
	this.sales = sales;
	this.stock = stock;
	this.imagePath = imagePath;
}
@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", sales=" + sales
			+ ", stock=" + stock + ", imagePath=" + imagePath + "]";
}
public void setAuthor(String author) {
	this.author = author;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Integer getSales() {
	return sales;
}
public void setSales(Integer sales) {
	this.sales = sales;
}
public Integer getStock() {
	return stock;
}
public void setStock(Integer stock) {
	this.stock = stock;
}
public String getImagePath() {
	return imagePath;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}
  
}
