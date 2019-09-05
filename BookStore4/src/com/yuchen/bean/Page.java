package com.yuchen.bean;

import java.util.List;

public class Page<T> {

	private List<T>list; //查询出的数据存放到集合
	@Override
	public String toString() {
		return "Page [list=" + list + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", totleSize="
				+ totleSize + ", totlePageNo=" + totlePageNo + ", path=" + path + ", defauleMinPrice=" + defauleMinPrice
				+ ", defaultMaxPrice=" + defaultMaxPrice + "]";
	}
	private int currentPage; //当前页
    private int pageSize;    //每页显示数
    private int totleSize;   // 总数量
	private int totlePageNo; //总页数
	private String path; //当前域名地址
	private double defauleMinPrice;
	private double defaultMaxPrice;
	
	
	
    public double getDefauleMinPrice() {
		return defauleMinPrice;
	}
	public void setDefauleMinPrice(double defauleMinPrice) {
		this.defauleMinPrice = defauleMinPrice;
	}
	public double getDefaultMaxPrice() {
		return defaultMaxPrice;
	}
	public void setDefaultMaxPrice(double defaultMaxPrice) {
		this.defaultMaxPrice = defaultMaxPrice;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if (currentPage >= 1) {
			this.currentPage = currentPage;
		}else {
			this.currentPage = 1;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}else {
			this.pageSize = 10;
		}
	}
	public int getTotleSize() {
		return totleSize;
	}
	public void setTotleSize(int totleSize) {
		this.totleSize = totleSize;
	}
	public int getTotlePageNo() {
		if (totleSize % pageSize == 0) {
			return totleSize / pageSize;
		}else{
			return totleSize / pageSize + 1;
		}
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
