package com.jwj.russianblue.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.joda.time.DateTime;

import com.jwj.russianblue.core.entity.RbEntityBase;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class RbUser extends RbEntityBase {
	private String code;
	private String name;
	private String password;
	private String description;
	private DateTime firstLoginTime;
	private DateTime lastLoginTime;
	private Integer loginCount;
	private Integer errorCount;
}
