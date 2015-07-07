package com.tsingsoft.system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tsingsoft.dao.common.IOperations;
import com.tsingsoft.service.common.AbstractService;
import com.tsingsoft.system.dao.UserDao;
import com.tsingsoft.system.entity.User;


/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：UserServiceImpl  
* 类描述：  用户管理服务接口实现类
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:25:51  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:25:51  
* 修改备注：  
* @version  V1.0 
*
 */
@Service("userService")
public class UserServiceImpl extends AbstractService<User> implements UserService {

	@Resource(name="userDao")
	private  UserDao  userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	protected IOperations<User> getDao() {
		return this.userDao;
	}
 
    public UserServiceImpl() {
        super();
    }
 
}
