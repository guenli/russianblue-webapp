package com.jwj.russianblue.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;

import org.springframework.stereotype.Component;

import com.jwj.russianblue.core.dao.RbDao;
import com.jwj.russianblue.core.service.RbServiceImpl;
import com.jwj.russianblue.dao.SecUserDao;
import com.jwj.russianblue.entity.SecUser;
import com.jwj.russianblue.service.SecUserService;

@Getter
@Component("secUserService")
@SuppressWarnings("serial")
public class SecUserServiceImpl extends RbServiceImpl<SecUser> implements SecUserService {
	
	@Resource(name="secUserDao")
	@Override
	public <DAO extends RbDao<SecUser, BigDecimal>> void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public List<SecUser> getByUserName(String username) {
		return ((SecUserDao) getDao()).findByUserName(username);
	}

	@Override
	public void doubleInsert(SecUser user) {
		final SecUserDao secUserDao = (SecUserDao) getDao();
		secUserDao.save(user);
		secUserDao.save(user);
	}
	
}
