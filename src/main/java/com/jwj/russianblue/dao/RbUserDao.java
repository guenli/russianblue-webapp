package com.jwj.russianblue.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.jwj.russianblue.core.dao.RbDao;
import com.jwj.russianblue.entity.RbUser;

@Component("rbUserDao")
public interface RbUserDao extends RbDao<RbUser, BigDecimal> {

	public RbUser findByCode(@Param("code") String code);

	public List<RbUser> findByName(@Param("name") String name);

}
