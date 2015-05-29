package com.jwj.russianblue.core.service;

import java.io.Serializable;

import com.jwj.russianblue.core.entity.RbEntity;

public interface RbEntityService<T extends RbEntity, PK extends Serializable> extends RbService<T> {

	public T getById(PK pk);

	public Integer save(T entity);

	public Integer update(T entity);

	public Integer delete(T entity);

	public Integer delete(PK pk);

}
