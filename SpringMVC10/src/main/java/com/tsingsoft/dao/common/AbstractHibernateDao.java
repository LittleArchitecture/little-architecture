package com.tsingsoft.dao.common;

import java.io.Serializable;
import java.util.List;

import com.google.common.base.Preconditions;

import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
 

/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：AbstractHibernateDao  
* 类描述：  Hibernate接口实现类
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:31:48  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:31:48  
* 修改备注：  
* @version  V1.0 
*
 */
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {
    
    private Class<T> clazz;
    
    @PersistenceContext  
    private EntityManager em;  

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }
    

	@Override
    public final T findOne(final long id) {
    	return (T)em.find(clazz, id);
    }

	@SuppressWarnings("unchecked")
	@Override
    public final List<T> findAll() {
    	return (List<T>) em.getEntityGraphs(clazz);
//        return (List<T>) em.getEntityGraphs(clazz);
    }

    @Override
    public final void create(final T entity) {
         Preconditions.checkNotNull(entity);
         em.persist(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        em.persist(entity);
        return entity;
    }

    @Override
    public final void delete(final T entity) {
         Preconditions.checkNotNull(entity);
         em.remove(entity);
    }

  
    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }
    
}