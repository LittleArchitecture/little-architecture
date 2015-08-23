package com.tsingsoft.dao.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：IOperations  
* 类描述：  DAO操作接口
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:31:26  
* 修改人：fchao Zhai  
* 修改时间：2015-7-14 下午4:31:26  
* 修改备注：增加JPA相关的数据库操作方法
* @version  V1.0 
*
 */
public interface IOperations<T extends Serializable> {
	
	/**
	 * 功能描述：获取一个对象
	 * @param id 对象的ID
	 * @return 返回查找根据ID查找的对象
	 */
	
    T findOne(final long id) throws Exception;

	/**
	 * 功能描述：查询所有对象
	 * @return  返回查找根据查找的所有对象
	 */
    List<T> findAll(String namedQuery) throws Exception;

    /**
     * 功能描述：创建对象(可确定为新建实体；返回处于托管状态的实例)
     * @param entity 需要创建的对象
     */
    void create(final T entity) throws Exception;

    /**
     * 功能描述：更新对象
     * @param entity 需要更新的对象
     * @return 更新后的对象
     */
    T update(final T entity) throws Exception;

    /**
     * 功能描述：删除对象
     * @param entity 删除的对象
     */
    void delete(final T entity) throws Exception;

    /**
     * 功能描述：使用ID删除对象
     * @param entityId  ID删除对象
     */
    void deleteById(final long entityId) throws Exception;

     
    /**
     * 可确定为新建实体；返回处于托管状态的实例
     * @param entity 实体对象
     * @return
     */
    public void persist(T entity) throws Exception;
 
    /**
     * 可确定为新建实体；返回处于托管状态的实例
     * @param entityCollection 保存对象的集合
     * @return
     */
    public boolean persist(Collection<T> entityCollection) throws Exception;
 
    /**
     * 若数据库中已有此记录，置为托管状态
     * @param entity
     * @return
     */
    public T merge(T entity) throws Exception;
 
    /**
     * 若数据库中已有此记录，置为托管状态
     * @param entityCollection
     * @return
     */
    public Collection<T> merge(Collection<T> entityCollection) throws Exception;
 
    /**
     * 删除
     * @param entity
     */
    public void remove(T entity) throws Exception;
 
    /**
     * 批量删除 传入集合
     * @param entityCollection
     */
    public void remove(Collection<T> entityCollection) throws Exception;
 
    /**
     * 删除指定id、指定class的实例
     * @param clazz
     * @param id
     */
    public void remove(Class<T> clazz, String id) throws Exception;
 
    /**
     * 删除指定id、指定class的实例
     * @param clazz
     * @param ids
     */
    public void remove(Class<T> clazz, Collection<String> ids) throws Exception;
 
    /**
     * 清除一级缓存
     */
    public void clear() throws Exception;
 
    /**
     * 将对象置为游离状态
     * @param entity
     */
    public void detach(T entity) throws Exception;
 
    /**
     * 将对象置为游离状态
     * @param entityCollection
     */
    public void detach(Collection<T> entityCollection) throws Exception;
 
    /**
     * 检查实例是否处于托管状态
     * @param entity
     * @return
     */
    public boolean isManaged(T entity) throws Exception;
 
    /**
     * 同步jpa容器和数据库
     */
    public void flush() throws Exception;

}
