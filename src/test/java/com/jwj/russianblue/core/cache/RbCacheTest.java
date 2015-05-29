package com.jwj.russianblue.core.cache;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.jwj.russianblue.core.cache.RbCache;
import com.jwj.russianblue.core.cache.RbCacheService;
import com.jwj.russianblue.core.cache.RbCacheServiceBase;
import com.jwj.russianblue.entity.RbUser;
import com.jwj.russianblue.service.RbUserService;
import com.jwj.russianblue.test.GenericTest;


public class RbCacheTest extends GenericTest {

	@Resource(name="rbUserService")
	private RbUserService userService;

	@Test
	public void testCacheRbUser() {
		RbCacheService<String, RbUser> rbCacheService = new RbCacheServiceBase<String, RbUser>(userService) {
			@Override
			public Optional<RbUser> load(String key) {
				final RbUserService service = (RbUserService) getService();
				Optional<RbUser> val = Optional.ofNullable(service.getByCode(key));
				return val;
			}
		};

		LoadingCache<String, Optional<RbUser>> userCache = RbCache.prepare(rbCacheService).maximumSize(2000).recordStats().build();
		for (int i=0; i<1000; i++) {
			final int randomInt = new Random().nextInt(10);
			String key = (randomInt == 5)? "admin": (randomInt == 8)? "user": ("KEY:" + randomInt);
			userCache.getUnchecked(key);
		}

		CacheStats userCacheStats = userCache.stats();
		Assert.assertEquals(1000, userCacheStats.requestCount());
		Assert.assertEquals(990, userCacheStats.hitCount());
		Assert.assertEquals(10, userCacheStats.missCount());
	}

}
