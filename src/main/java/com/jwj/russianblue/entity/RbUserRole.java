package com.jwj.russianblue.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jwj.russianblue.core.entity.RbEntityLogTimeBase;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class RbUserRole extends RbEntityLogTimeBase {
	
	private Long userId;	// RbUser.id
	private Long roleId;	// RbRole.id
	
}
