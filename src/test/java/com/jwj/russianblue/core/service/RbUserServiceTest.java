package com.jwj.russianblue.core.service;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterables;
import com.jwj.russianblue.core.entity.factory.RbEntityFactory;
import com.jwj.russianblue.core.enums.SystemUser;
import com.jwj.russianblue.core.test.GenericTest;
import com.jwj.russianblue.entity.RbUser;
import com.jwj.russianblue.service.RbUserService;

public class RbUserServiceTest extends GenericTest {

	@Autowired
	private RbUserService rbUserService;

	@Test
	public void testFindByName() {
		List<RbUser> users = rbUserService.getByName("admin");
		Assert.assertEquals(1, Iterables.size(users));
	}

	@Test
	public void testDelete() {
		List<RbUser> users = rbUserService.getByName("TEST");
		for (RbUser user : users) {
			rbUserService.delete(user);
		}
	}

	@Test
	public void testSave() {
		RbUser user = RbEntityFactory.createEntity(RbUser.class, SystemUser.SYSTEM.toString(), DateTime.now());
		user.setCode("TESTSAVE");
		user.setName("TESTSAVE");
		user.setPassword("12345678");
		user.setDescription("TEST DESC.");
		user.setFirstLoginTime(DateTime.now());
		user.setLastLoginTime(DateTime.now());
		user.setLoginCount(0);
		user.setErrorCount(0);
		int result = rbUserService.save(user);
		Assert.assertEquals(1, result);
	}

	@Test
	public void testSaveDouble() {
		try {
			RbUser user = RbEntityFactory.createEntity(RbUser.class, SystemUser.SYSTEM.toString(), DateTime.now());
			user.setCode("TEST");
			user.setName("TEST");
			user.setPassword("12345678");
			user.setDescription("TEST DESC.");
			user.setFirstLoginTime(DateTime.now());
			user.setLastLoginTime(DateTime.now());
			user.setLoginCount(0);
			user.setErrorCount(0);
			rbUserService.saveDouble(user);
		}catch(Exception e){
			e.printStackTrace();
		}

		List<RbUser> users = rbUserService.getByName("TEST");
		Assert.assertEquals(0, Iterables.size(users));
	}

}