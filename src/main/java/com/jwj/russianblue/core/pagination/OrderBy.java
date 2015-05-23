package com.jwj.russianblue.core.pagination;

import java.util.List;

import lombok.Getter;

import com.google.common.collect.Lists;

@Getter
public class OrderBy {
	private List<Order> orders = Lists.newArrayList();
	
	public void add(Order order) {
		getOrders().add(order);
	}
	
	public void clear() {
		getOrders().clear();
	}
	
}
