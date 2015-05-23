package com.jwj.russianblue.core.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.jwj.russianblue.core.enums.SortOption;

@Getter
@Setter
@AllArgsConstructor
public class Order {
	private SortOption option;
	private String name;
}
