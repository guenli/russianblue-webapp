package com.jwj.russianblue.core.cache;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.jwj.russianblue.core.entity.RbModel;

public class RbCache<K, V extends RbModel> {
	private static final long DEFAULT_MAX_SIZE = 1000;

	private long maximumSize = DEFAULT_MAX_SIZE;
	private long expireAfterWriteDuration = -1;
	private TimeUnit expireAfterWriteUnit = null;
	private boolean recordStats = false;

	private RbCacheService<K, V> rbCacheService;

	private RbCache(RbCacheService<K, V> rbCacheService) {
		this.rbCacheService = rbCacheService;
	}

	public static <K, V extends RbModel> RbCache<K, V> prepare(RbCacheService<K, V> rbCacheService) {
		Preconditions.checkArgument(!Objects.isNull(rbCacheService));
		RbCache<K, V> rbCache = new RbCache<K, V>(rbCacheService);
		return rbCache;
	}

	public RbCache<K, V> maximumSize(long maximumSize) {
		this.maximumSize = maximumSize;
		return this;
	}

	public RbCache<K, V> expireAfterWrite(long unit, TimeUnit timeUnit) {
		this.expireAfterWriteDuration = unit;
		this.expireAfterWriteUnit = timeUnit;
		return this;
	}

	public RbCache<K, V> recordStats() {
		this.recordStats = true;
		return this;
	}

	public LoadingCache<K, Optional<V>> build() {
		final RbCacheService<K, V> rbCacheService = getRbCacheService();

		CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder().maximumSize(getMaximumSize());
		if (getRecordStats()) {
			cacheBuilder.recordStats();
		}

		if (getExpireAfterWriteDuration() >= 0 && !Objects.isNull(getExpireAfterWriteUnit())) {
			cacheBuilder.expireAfterWrite(getExpireAfterWriteDuration(), getExpireAfterWriteUnit());
		}

		LoadingCache<K, Optional<V>> cache = cacheBuilder.build(new CacheLoader<K, Optional<V>>() {
			@Override
			public Optional<V> load(K key) throws Exception {
				return rbCacheService.load(key);
			}
		});

		return cache;
	}

	public long getMaximumSize() {
		return maximumSize;
	}

	public long getExpireAfterWriteDuration() {
		return expireAfterWriteDuration;
	}

	public TimeUnit getExpireAfterWriteUnit() {
		return expireAfterWriteUnit;
	}

	public RbCacheService<K, V> getRbCacheService() {
		return rbCacheService;
	}

	public boolean getRecordStats() {
		return recordStats;
	}

}
