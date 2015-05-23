package com.jwj.russianblue.core.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.jwj.russianblue.core.dao.provider.MybatisSqlProvider;
import com.jwj.russianblue.core.entity.RbEntity;
import com.jwj.russianblue.core.pagination.Pagination;

public interface RbDao<T extends RbEntity, PK extends Serializable> extends Serializable {

	public Long count(Object expression);

	public T findByPk(PK pk);

	public <E extends T> List<E> findAll(Object expression, Pagination pagination);

	@InsertProvider(type = MybatisSqlProvider.class, method = "save")
	public <E extends T> Integer save(E entity);

	@UpdateProvider(type = MybatisSqlProvider.class, method = "update")
	public <E extends T> Integer update(E entity);

	@DeleteProvider(type = MybatisSqlProvider.class, method = "delete")
	public <E extends T> Integer delete(E entity);

}
