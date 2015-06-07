package com.jwj.russianblue.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.joda.time.DateTime;

import com.jwj.russianblue.core.entity.RbEntityLogTimeBase;
import com.jwj.russianblue.core.enums.UserType;
import com.jwj.russianblue.core.enums.YesNo;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class RbUser extends RbEntityLogTimeBase {
	
	private String code;
	private String name;
	private String description;
	
	private UserType userType;
	private String password;
	private DateTime firstLoginTime;
	private DateTime lastLoginTime;
	private Integer loginCount;
	private Integer errorCount;
	
	private DateTime expireTime;
	private YesNo lockStatus;
	
	/** get account is expire or not **/
	public boolean getIsExpire() {
		if (expireTime.getMillis() < System.currentTimeMillis()) {
			return true;
		}else {
			return false;
		}
	}
	
}
