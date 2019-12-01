package com.web.dto;

public class Criteria {
	
	private int page;
	private int perPageNum;
	private int instSection;
	
	public int getInstSection() {
		return instSection;
	}

	public void setInstSection(int instSection) {
		this.instSection = instSection;
	}

	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 9;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}
		else {
			this.page = page;
		}
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if(pageCount != cnt) {
			this.perPageNum = cnt;
		}
		else {
			this.perPageNum = pageCount;
		}
			
	}
	
}
