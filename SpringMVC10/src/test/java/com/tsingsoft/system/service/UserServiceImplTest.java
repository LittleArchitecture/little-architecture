package com.tsingsoft.system.service;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsingsoft.system.entity.User;

/**
 * 
*   
* 项目名称：SpringMVC10  
* 类名称：UserServiceImplTest  
* 类描述：测试对用户类的方法
* 创建人：fchao Zhai
* 创建时间：2015-7-14 下午4:28:26  
* 修改人：Administrator  
* 修改时间：2015-7-14 下午4:28:26  
* 修改备注：  
* @version  V1.0 
*
 */
public class UserServiceImplTest extends TestCase {

	private ApplicationContext ctx;

	@Override
	protected void setUp() throws Exception {
		String[] locations = { "config/Sping-Context.xml","config/mvc-dispatcher-servlet.xml","config/Spring-JPA-Hibernate.xml"};
		ctx = new ClassPathXmlApplicationContext(locations);
	}
	
	public void testFindAll() {

		List<User>  userList = null;

		UserService userService = (UserService) ctx.getBean("userService");
		try {
			userList = userService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(userList);
	}

	public void testCreate() {

		UserService userService = (UserService) ctx.getBean("userService");
		User user = new User();
		user.setId(1);
		user.setName("张三");
		user.setAge("12");
		try {
			userService.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testEdit() {

		UserService userService = (UserService) ctx.getBean("userService");
		User user = new User();
		user.setId(1);
		user.setName("王五");
		user.setAge("12");
		try {
			User userCurr = userService.update(user);
			assertEquals(1, userCurr.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testQuery() {

		User userEntity = null;

		UserService userService = (UserService) ctx.getBean("userService");
		User user = new User();
		user.setId(1);
		try {
			userEntity = userService.findOne(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(userEntity);
		assertEquals(1, userEntity.getId());
	}
	
	public void testDel() {

		UserService userService = (UserService) ctx.getBean("userService");
		User user = new User();
		user.setId(1);
		user.setName("张三");
		user.setAge("12");
		try {
			userService.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
