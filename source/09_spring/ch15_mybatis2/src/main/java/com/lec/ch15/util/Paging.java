package com.lec.ch15.util;

import lombok.Data;

@Data
public class Paging {
	private int currentPage = 1;
	private int pageSize;
	private int blockSize;
	private int startRow;
	private int endRow;
	private int totCnt;
	private int pageCnt;
	private int startPage;
	private int endPage;
	// empList.do 또는 empList.do?pageNum=2
	// Paging paging = new Paging(14,"2", 10, 5);
	public Paging(int totCnt, String pageNum, int pageSize, int blockSize) {
		this.totCnt = totCnt;
		if(pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		startRow = (currentPage-1) * pageSize + 1;
		endRow = startRow + pageSize -1;
		pageCnt = (int) Math.ceil( (double)totCnt / pageSize);
		startPage = ( (currentPage-1) / blockSize) * blockSize + 1;
		endPage = startPage + blockSize - 1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
	}
}
