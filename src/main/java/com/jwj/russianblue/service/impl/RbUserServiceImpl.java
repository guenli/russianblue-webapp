package com.jwj.russianblue.service.impl;

import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;

import org.springframework.stereotype.Component;

import com.jwj.russianblue.core.service.RbEntityServiceImpl;
import com.jwj.russianblue.dao.RbUserDao;
import com.jwj.russianblue.entity.RbUser;
import com.jwj.russianblue.service.RbUserService;

@Getter
@Component("rbUserService")
@SuppressWarnings("serial")
public class RbUserServiceImpl extends RbEntityServiceImpl<RbUser, RbUserDao> implements RbUserService {

	@Resource(name="rbUserDao")
	@Override
	public void setDao(RbUserDao dao) {
		this.dao = dao;
	}

	@Override
	public RbUser getByCode(String code) {
		return getDao().findByCode(code);
	}

	@Override
	public List<RbUser> getByName(String username) {
		return getDao().findByName(username);
	}

	@Override
	public void saveDouble(RbUser user) {
		final RbUserDao secUserDao = getDao();
		secUserDao.save(user);
		secUserDao.save(user);
		System.err.print(true);
	}

}
