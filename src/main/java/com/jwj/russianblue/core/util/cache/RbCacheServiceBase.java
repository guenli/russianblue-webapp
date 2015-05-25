package com.jwj.russianblue.core.util.cache;

import java.io.Serializable;

import com.jwj.russianblue.core.entity.RbEntity;
import com.jwj.russianblue.core.service.RbService;
import com.jwj.russianblue.core.util.cache.RbCacheService;


public abstract class RbCacheServiceBase<KEY, T extends RbEntity, PK extends Serializable> implements RbCacheService<KEY, T> {
	
	private RbService<T, PK> service;
	
	public RbCacheServiceBase(RbService<T, PK> service) {
		this.service = service;
	}
	
	protected abstract T getFromService(RbService<T, PK> service, KEY key);
	
	@Override
	public T get(KEY key) {
		T val = getFromService(service, key);
		return val;
	}
	
}
