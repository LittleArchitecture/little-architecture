package com.tsingsoft.system.dao;

import com.tsingsoft.dao.common.IOperations;
import com.tsingsoft.system.entity.User;



/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：UserDao  
* 类描述：  用户管理DAO接口类
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:28:15  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:28:15  
* 修改备注：  
* @version  V1.0 
*
 */
public interface UserDao  extends IOperations<User> {
	 
	 //让所有的DAO都实现基本的操作接口IOperations
     //除了实现IOperations中的基本操作之外，特定的DAO要实现其他操作可以在对应的接口DAO中定义方法，
     //此处UserDao的接口IUserDao不需要实现其他方法
	
}
