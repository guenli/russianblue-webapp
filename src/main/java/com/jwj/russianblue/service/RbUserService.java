package com.jwj.russianblue.service;

import java.math.BigDecimal;
import java.util.List;

import com.jwj.russianblue.core.service.RbService;
import com.jwj.russianblue.entity.RbUser;

public interface RbUserService extends RbService<RbUser, BigDecimal> {

	public List<RbUser> getByName(String name);

	public void saveDouble(RbUser user);

}
