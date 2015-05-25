package com.jwj.russianblue.core.entity;

import java.math.BigDecimal;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateTime;

import com.jwj.russianblue.core.enums.YesNo;

@Getter
@Setter
@SuppressWarnings("serial")
public class RbEntityBase implements RbEntity {

	@Transient
	private BigDecimal id;

	private String createUser;
	private DateTime createTime;
	private String modifyUser;
	private DateTime modifyTime;
	private YesNo sysStatus;

}
