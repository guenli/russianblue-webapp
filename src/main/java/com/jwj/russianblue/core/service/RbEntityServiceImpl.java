package com.jwj.russianblue.core.service;

import java.math.BigDecimal;

import com.jwj.russianblue.core.dao.RbDao;
import com.jwj.russianblue.core.entity.RbEntity;

@SuppressWarnings("serial")
public abstract class RbEntityServiceImpl<T extends RbEntity, DAO extends RbDao<T, BigDecimal>>
	extends RbServiceImpl<T>
	implements RbEntityService<T, BigDecimal> {

	protected RbDao<T, BigDecimal> dao;

	@Override
	public T getById(BigDecimal pk) {
		T entity = getDao().findByPk(pk);
		return entity;
	}

	@Override
	public Integer save(T entity) {
		int count = getDao().save(entity);
		return count;
	}

	@Override
	public Integer update(T entity) {
		int count = getDao().update(entity);
		return count;
	}

	@Override
	public Integer delete(T entity) {
		int count = getDao().delete(entity);
		return count;
	}

	@Override
	public Integer delete(final BigDecimal pk) {
		T entity = getById(pk);
		if (entity != null) {
			int count = getDao().delete(entity);
			return count;
		}else{
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public DAO getDao() {
		return (DAO) dao;
	}

	public abstract void setDao(DAO dao);

}
