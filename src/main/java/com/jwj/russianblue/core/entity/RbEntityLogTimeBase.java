package com.jwj.russianblue.core.entity;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateTime;

import com.jwj.russianblue.core.enums.YesNo;

@Getter
@Setter
@SuppressWarnings("serial")
public abstract class RbEntityLogTimeBase extends RbEntityBase {

	protected String createUser;
	protected DateTime createTime;
	protected String modifyUser;
	protected DateTime modifyTime;
	protected YesNo sysStatus;
	
}
