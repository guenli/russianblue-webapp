package com.jwj.russianblue.core.entity;

import java.math.BigDecimal;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.DateTime;

@Getter
@Setter
@SuppressWarnings("serial")
public class RbEntityBase implements RbEntity {
	
	@Transient
	private BigDecimal id;
	
	private String createdBy;
	private DateTime createdDate;
	private String lastModifiedBy;
	private DateTime lastModifiedDate;
	
}
