package com.jwj.russianblue.core.cache;

import java.util.Optional;

import com.jwj.russianblue.core.entity.RbModel;
import com.jwj.russianblue.core.service.RbService;


public abstract class RbCacheServiceBase<K, V extends RbModel> implements RbCacheService<K, V> {

	private RbService<?> service;

	/** constructor **/
	public <T extends RbModel> RbCacheServiceBase(RbService<T> service) {
		this.service = service;
	}

	@Override
	public abstract Optional<V> load(K key);

	protected RbService<? extends RbModel> getService() {
		return service;
	}

}
