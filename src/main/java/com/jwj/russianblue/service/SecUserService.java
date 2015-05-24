package com.jwj.russianblue.service;

import java.math.BigDecimal;
import java.util.List;

import com.jwj.russianblue.core.service.RbService;
import com.jwj.russianblue.entity.SecUser;

public interface SecUserService extends RbService<SecUser, BigDecimal> {

	public List<SecUser> getByUserName(String username);
	
	public void saveDouble(SecUser user);
	
}
