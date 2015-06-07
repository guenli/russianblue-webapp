package com.jwj.russianblue.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jwj.russianblue.core.entity.RbEntityLogTimeBase;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class RbRole extends RbEntityLogTimeBase {
	
	private String code;
	private String name;
	private String description;
	
}
