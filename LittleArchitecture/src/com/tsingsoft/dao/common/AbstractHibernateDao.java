package com.tsingsoft.dao.common;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.common.base.Preconditions;


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
    
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }
    
    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public final T findOne(final long id) {
        return (T)getCurrentSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public final void create(final T entity) {
         Preconditions.checkNotNull(entity);
         // getCurrentSession().persist(entity);
         getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().merge(entity);
        return entity;
        //return (T)getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
         Preconditions.checkNotNull(entity);
         getCurrentSession().delete(entity);
    }

  
    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }
    
}