package com.jwj.russianblue.core.entity.factory;

import org.joda.time.DateTime;

import com.jwj.russianblue.core.entity.RbEntityBase;
import com.jwj.russianblue.core.entity.RbEntityLogTimeBase;
import com.jwj.russianblue.core.enums.YesNo;

public class RbEntityFactory {

	public static <T extends RbEntityBase> T createEntity(Class<T> entityClass, final String createUser, final DateTime createTime) {
		try {
			T entity = entityClass.newInstance();
			if (entityClass.isAssignableFrom(RbEntityLogTimeBase.class)) {
				((RbEntityLogTimeBase) entity).setCreateUser(createUser);
				((RbEntityLogTimeBase) entity).setCreateTime(createTime);
				((RbEntityLogTimeBase) entity).setModifyUser(createUser);
				((RbEntityLogTimeBase) entity).setModifyTime(createTime);
				((RbEntityLogTimeBase) entity).setSysStatus(YesNo.Y);
			}
			return entity;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
