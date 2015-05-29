package com.jwj.russianblue.core.cache;

import java.util.Optional;

import com.jwj.russianblue.core.entity.RbModel;

public interface RbCacheService<K, V extends RbModel> {

	public Optional<V> load(K key);

}
