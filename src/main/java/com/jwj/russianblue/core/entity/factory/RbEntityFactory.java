package com.jwj.russianblue.core.entity.factory;

import org.joda.time.DateTime;

import com.jwj.russianblue.core.entity.RbEntityBase;

public class RbEntityFactory {
	
	public static <T extends RbEntityBase> T createEntity(Class<T> entityClass, final String createUser, final DateTime createTime) {
		try {
			T entity = entityClass.newInstance();
			entity.setCreatedBy(createUser);
			entity.setCreatedDate(createTime);
			entity.setLastModifiedBy(createUser);
			entity.setLastModifiedDate(createTime);
			
			return entity;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
