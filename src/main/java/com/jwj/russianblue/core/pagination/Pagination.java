package com.jwj.russianblue.core.pagination;

import java.io.Serializable;

import org.apache.ibatis.session.RowBounds;

@SuppressWarnings("serial")
public class Pagination extends RowBounds implements Serializable {

	public static final int DEFAULT_PAGE = 1;
	public static final int DEFAULT_SIZE = 10;

	private int page;
	private int size;
	private OrderBy orderBy;

	public Pagination() {
		this(DEFAULT_PAGE, DEFAULT_SIZE);
	}

	public Pagination(int page, int size) {
		this(page, size, new OrderBy());
	}

	public Pagination(int page, int size, OrderBy orderBy) {
		super(NO_ROW_OFFSET, NO_ROW_LIMIT);
		this.page = page;
		this.size = size;
		this.orderBy = orderBy;
	}

	public OrderBy getOrderBy() {
		return orderBy;
	}

	public int getPage() {
		return page;
	}

	public int getPageOffset() {
		return (page - 1) * size;
	}

	public int getSize() {
		return size;
	}

	public void setOrderBy(OrderBy orderBy) {
		this.orderBy = orderBy;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
