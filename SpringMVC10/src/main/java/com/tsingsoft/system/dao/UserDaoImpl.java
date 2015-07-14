package com.tsingsoft.system.dao;


import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tsingsoft.dao.common.AbstractHibernateDao;
import com.tsingsoft.system.entity.User;


/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：UserDaoImpl  
* 类描述：  用户管理DAO接口实现类
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:28:35  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:28:35  
* 修改备注：  
* @version  V1.0 
*
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends AbstractHibernateDao<User>  implements UserDao {

    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }
}