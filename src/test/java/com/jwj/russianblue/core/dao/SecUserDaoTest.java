//package com.jwj.russianblue.core.dao;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.junit.Assert; import org.junit.Test;
//
//import tw.com.softleader.bcmn.entity.SecUser;
//import tw.com.softleader.core.dao.paging.OnePageRequest;
//import tw.com.softleader.core.enums.SystemStatus;
//import tw.com.softleader.core.test.GenericTest;
//
//public class SecUserDaoTest extends GenericTest{
//
//	@Inject
//	private SecUserDao secUserDao;
//	
//	@Test
//	public void testSave() {
//		SecUser entity = new SecUser();
//		SecUser user = new SecUser();
//		try {
//			user.setId(new BigDecimal(1));
//			user.setUsername("admin");
//		} catch (Exception e) {
//			Assert.fail(e.getMessage());
//			org.junit.Assert.fail();
//		}
//		entity.initInsert(user);
//		entity.setUsername("asia01");
//		entity.setPassword("asia01");
//		entity.setLocalName("asia01");
//		entity.setIdno("N218364105");
//		entity.setSex("FEMALE");
//		entity.setEmail("asia01@a.b.c");
//		entity.setChannelId(new BigDecimal(11));
//		secUserDao.save(entity);
//		log.debug("\n SecUser save (id:{}) success.", entity.getId());
//		
//	}
//	
//	@Test
//	public void testFindAll() {
//		SecUser queryUserEntity = new SecUser();
//		queryUserEntity.setChannelId(new BigDecimal("1"));
//		queryUserEntity.setStatus(SystemStatus.Y);
//		
//		List<SecUser> activeUsers = secUserDao.findAll(queryUserEntity, new OnePageRequest());
//		
//		for (SecUser user : activeUsers) {
//			log.debug("user==>{}", user);
//		}
//	}
//	
//}