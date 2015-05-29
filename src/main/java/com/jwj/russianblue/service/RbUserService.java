package com.jwj.russianblue.service;

import java.math.BigDecimal;
import java.util.List;

import com.jwj.russianblue.core.service.RbEntityService;
import com.jwj.russianblue.entity.RbUser;

public interface RbUserService extends RbEntityService<RbUser, BigDecimal> {

	public RbUser getByCode(String code);

	public List<RbUser> getByName(String name);

	public void saveDouble(RbUser user);

}
