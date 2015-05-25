package com.jwj.russianblue.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;

import org.springframework.stereotype.Component;

import com.jwj.russianblue.core.dao.RbDao;
import com.jwj.russianblue.core.service.RbServiceImpl;
import com.jwj.russianblue.dao.RbUserDao;
import com.jwj.russianblue.entity.RbUser;
import com.jwj.russianblue.service.RbUserService;

@Getter
@Component("rbUserService")
@SuppressWarnings("serial")
public class RbUserServiceImpl extends RbServiceImpl<RbUser> implements RbUserService {

	@Resource(name="rbUserDao")
	@Override
	public <DAO extends RbDao<RbUser, BigDecimal>> void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public List<RbUser> getByName(String username) {
		return ((RbUserDao) getDao()).findByName(username);
	}

	@Override
	public void saveDouble(RbUser user) {
		final RbUserDao secUserDao = (RbUserDao) getDao();
		secUserDao.save(user);
		secUserDao.save(user);
	}

}
