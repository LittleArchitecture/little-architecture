package com.tsingsoft.service.common;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import com.tsingsoft.dao.common.IOperations;



/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：AbstractService  
* 类描述：  服务层接口类
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:30:47  
* 修改人：fchao Zhai  
* 修改时间：2015-7-14 下午4:31:26  
* 修改备注：  
* @version  V1.0 
*
 */
@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    
	protected abstract IOperations<T> getDao()  throws Exception;

	@Override
	public void persist(T entity) throws Exception {
		getDao().persist(entity);
	}

	@Override
	public boolean persist(Collection<T> entityCollection) throws Exception {
		return getDao().persist(entityCollection);
	}

	@Override
	public T merge(T entity) throws Exception {
		return getDao().merge(entity);
	}

	@Override
	public Collection<T> merge(Collection<T> entityCollection) throws Exception {
		return getDao().merge(entityCollection);
	}

	@Override
	public void remove(T entity) throws Exception {
		getDao().remove(entity);
	}

	@Override
	public void remove(Collection<T> entityCollection) throws Exception {
		getDao().remove(entityCollection);
	}

	@Override
	public void remove(Class<T> clazz, String id) throws Exception {
		getDao().remove(clazz, id);
	}

	@Override
	public void remove(Class<T> clazz, Collection<String> ids) throws Exception {
		getDao().remove(clazz, ids);
	}

	@Override
	public void clear() throws Exception {
		getDao().clear();
	}

	@Override
	public void detach(T entity) throws Exception {
		getDao().detach(entity);
	}

	@Override
	public void detach(Collection<T> entityCollection) throws Exception {
		getDao().detach(entityCollection);
	}

	@Override
	public boolean isManaged(T entity) throws Exception {
		return getDao().isManaged(entity);
	}

	@Override
	public void flush() throws Exception {
		getDao().flush();
	}

	@Override
    public T findOne(final long id)  throws Exception{
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll()  throws Exception{
        return getDao().findAll();
    }

    @Override
    public void create(final T entity)  throws Exception{
        getDao().create(entity);
    }

    @Override
    public T update(final T entity)  throws Exception{
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity)  throws Exception{
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId)  throws Exception{
        getDao().deleteById(entityId);
    }

}