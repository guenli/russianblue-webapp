package com.jwj.russianblue.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jwj.russianblue.core.entity.RbEntityBase;

@Getter
@Setter
@ToString
@SuppressWarnings("serial")
public class SecUser extends RbEntityBase {
	private String username;
	private String password;
	private String status;
	private BigDecimal channelId;
	private String channelCode;
}
