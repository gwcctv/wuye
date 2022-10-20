package com.woniuxy.wuye.common.utils;

import lombok.Data;

import java.util.List;

/**
 *
 *封装
 */
@Data
public class PageBean<T> {
private List<T> data;//数据
private int currPage;//当前页数
private int totalPage;//总页数
private int totalNums;//总数量
private int pageSzie;//分页大小
private int currpageSzie;//当前页数据数量

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}

	public int getPageSzie() {
		return pageSzie;
	}

	public void setPageSzie(int pageSzie) {
		this.pageSzie = pageSzie;
	}

	public int getCurrpageSzie() {
		return currpageSzie;
	}

	public void setCurrpageSzie(int currpageSzie) {
		this.currpageSzie = currpageSzie;
	}

	public List<T> getData() {
		return data;
}
}
