package com.jwj.russianblue.core.dao;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Iterables;
import com.jwj.russianblue.core.entity.factory.RbEntityFactory;
import com.jwj.russianblue.core.enums.SystemUser;
import com.jwj.russianblue.core.test.GenericTest;
import com.jwj.russianblue.entity.SecUser;
import com.jwj.russianblue.service.SecUserService;

public class SecUserDaoTest extends GenericTest {

	@Autowired
	private SecUserService secUserService;

	@Test
	public void testFindByUserName() {
		List<SecUser> users = secUserService.getByUserName("admin");
		Assert.assertTrue(Iterables.size(users) > 0);
	}
	
	@Test
	public void testDelete() {
		List<SecUser> users = secUserService.getByUserName("jwjtest");
		for (SecUser user : users) {
			secUserService.delete(user);
		}
	}
	
	@Test
	public void testSave() {
		SecUser secUser = RbEntityFactory.createEntity(SecUser.class, SystemUser.SYSTEM.toString(), DateTime.now());
		secUser.setUsername("jwjtest");
		secUser.setPassword("jwjtest");
		secUser.setStatus("Y");
		secUser.setChannelId(BigDecimal.ONE);
		secUser.setChannelCode("code");
		int result = secUserService.save(secUser);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testDoubleSave() {
		SecUser secUser = RbEntityFactory.createEntity(SecUser.class, SystemUser.SYSTEM.toString(), DateTime.now());
		secUser.setUsername("jwjtest");
		secUser.setPassword("jwjtest");
		secUser.setStatus("Y");
		secUser.setChannelId(BigDecimal.ONE);
		secUser.setChannelCode("code");
		secUserService.doubleInsert(secUser);
	}

}