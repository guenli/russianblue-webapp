package com.jwj.russianblue.action;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.jwj.russianblue.core.entity.factory.RbEntityFactory;
import com.jwj.russianblue.core.enums.SystemUser;
import com.jwj.russianblue.entity.SecUser;
import com.jwj.russianblue.service.SecUserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	
	@Autowired
	private SecUserService userService;
	
	@Override
	public String execute() {
		SecUser secUser = RbEntityFactory.createEntity(SecUser.class, SystemUser.SYSTEM.toString(), DateTime.now());
		secUser.setUsername("xjwjtest");
		secUser.setPassword("xjwjtest");
		secUser.setStatus("Y");
		secUser.setChannelId(BigDecimal.ONE);
		secUser.setChannelCode("xcode");
		
		System.err.println(userService);
		userService.saveDouble(secUser);
		
//		List<SecUser> users = userService.getByUserName("xjwjtest");
//		for (SecUser user : users) {
//			userService.delete(user);
//		}
//		System.err.println(users);
		
		return SUCCESS;
	}
}
