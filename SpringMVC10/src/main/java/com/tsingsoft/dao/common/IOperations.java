package com.tsingsoft.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：IOperations  
* 类描述：  DAO操作接口
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:31:26  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:31:26  
* 修改备注：  
* @version  V1.0 
*
 */
public interface IOperations<T extends Serializable> {
    
	/**
	 * 功能描述：获取一个对象
	 * @param id 对象的ID
	 * @return 返回查找根据ID查找的对象
	 */
	
    T findOne(final long id);

	/**
	 * 功能描述：查询所有对象
	 * @return  返回查找根据查找的所有对象
	 */
    List<T> findAll();

    /**
     * 功能描述：创建对象
     * @param entity 需要创建的对象
     */
    void create(final T entity);

    /**
     * 功能描述：更新对象
     * @param entity 需要更新的对象
     * @return 更新后的对象
     */
    T update(final T entity);

    /**
     * 功能描述：删除对象
     * @param entity 删除的对象
     */
    void delete(final T entity);

    /**
     * 功能描述：使用ID删除对象
     * @param entityId  ID删除对象
     */
    void deleteById(final long entityId);
    


}
