package com.tsingsoft.service.common;


import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.tsingsoft.dao.common.IOperations;



/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：AbstractService  
* 类描述：  服务层接口类
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:30:47  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:30:47  
* 修改备注：  
* @version  V1.0 
*
 */
@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    
    protected abstract IOperations<T> getDao();

    @Override
    public T findOne(final long id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        getDao().deleteById(entityId);
    }

}