package com.jwj.russianblue.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jwj.russianblue.core.dao.RbDao;
import com.jwj.russianblue.entity.SecUser;

@Component("secUserDao")
public interface SecUserDao extends RbDao<SecUser, BigDecimal> {

	public List<SecUser> findByUserName(String username);
	
}
