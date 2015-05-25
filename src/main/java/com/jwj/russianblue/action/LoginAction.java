package com.jwj.russianblue.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwj.russianblue.service.RbUserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	@Autowired
	private RbUserService userService;

	@Override
	public String execute() {
		return SUCCESS;
	}
}
