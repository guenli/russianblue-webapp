package com.jwj.russianblue.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.jwj.russianblue.core.dao.RbDao;
import com.jwj.russianblue.entity.RbRole;

@Component("rbRoleDao")
public interface RbRoleDao extends RbDao<RbRole, BigDecimal> {

	public RbRole findByCode(@Param("code") String code);
	
	public List<RbRole> findByUserId(@Param("userId") Long userId);

}
