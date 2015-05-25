package com.jwj.russianblue.core.entity.factory;

import org.joda.time.DateTime;

import com.jwj.russianblue.core.entity.RbEntityBase;
import com.jwj.russianblue.core.enums.YesNo;

public class RbEntityFactory {

	public static <T extends RbEntityBase> T createEntity(Class<T> entityClass, final String createUser, final DateTime createTime) {
		try {
			T entity = entityClass.newInstance();
			entity.setCreateUser(createUser);
			entity.setCreateTime(createTime);
			entity.setModifyUser(createUser);
			entity.setModifyTime(createTime);
			entity.setSysStatus(YesNo.Y);

			return entity;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
