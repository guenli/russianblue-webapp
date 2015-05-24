package com.jwj.russianblue.core.service;

import java.io.Serializable;

import com.jwj.russianblue.core.entity.RbEntity;

public interface RbService<T extends RbEntity, PK extends Serializable> extends Serializable {
	
	public T getByPk(PK pk);

	public Integer save(T entity);

	public Integer update(T entity);

	public Integer delete(T entity);

	public Integer delete(PK pk);

}
