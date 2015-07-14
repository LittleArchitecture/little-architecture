package com.tsingsoft.dao.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.common.base.Preconditions;
 

/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：AbstractHibernateDao  
* 类描述：  Hibernate接口实现类
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:31:48  
* 修改人：fchao Zhai  
* 修改时间：2015-7-14 下午4:31:26  
* 修改备注：  
* @version  V1.0 
*
 */
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {
	@PersistenceContext
    private EntityManager em;  
	
    private Class<T> clazz;
    

	@Override
	public void persist(T entity) throws Exception {
		em.persist(entity);
	}


	@Override
	public boolean persist(Collection<T> entityCollection) throws Exception {
		return false;
	}


	@Override
	public T merge(T entity) throws Exception {
		return em.merge(entity);
	}


	@Override
	public Collection<T> merge(Collection<T> entityCollection) throws Exception {
		return null;
	}


	@Override
	public void remove(T entity) throws Exception {
		em.remove(entity);
	}


	@Override
	public void remove(Collection<T> entityCollection) throws Exception {
		
	}


	@Override
	public void remove(Class<T> clazz, String id) throws Exception {
		
	}


	@Override
	public void remove(Class<T> clazz, Collection<String> ids) throws Exception {
		
	}


	@Override
	public void clear() throws Exception {
		em.clear();
	}


	@Override
	public void detach(T entity) throws Exception {
		em.detach(entity);
	}


	@Override
	public void detach(Collection<T> entityCollection) throws Exception {
		em.detach(entityCollection);
	}


	@Override
	public boolean isManaged(T entity) throws Exception {
		return em.isOpen();
	}


	@Override
	public void flush() throws Exception {
		em.flush();
	}

	@Override
    public final T findOne(final long id) {
    	return (T)em.find(clazz, id);
    }

	@SuppressWarnings("unchecked")
	@Override
    public final List<T> findAll() {
		Query query = em.createNamedQuery("findAllUsers");
		return query.getResultList();
    }
	
    @Override
    public final void create(final T entity) throws Exception {
         Preconditions.checkNotNull(entity);
         em.persist(entity);
    }

    @Override
    public final T update(final T entity)  throws Exception{
        Preconditions.checkNotNull(entity);
        return em.merge(entity);
    }

    @Override
    public final void delete(final T entity)  throws Exception{
         Preconditions.checkNotNull(entity);
         em.remove(em.merge(entity));
    }

  
    @Override
    public final void deleteById(final long entityId)  throws Exception{
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }
    
    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }
    
}