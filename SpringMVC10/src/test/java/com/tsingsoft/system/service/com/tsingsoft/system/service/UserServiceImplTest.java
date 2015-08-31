package com.tsingsoft.system.service.com.tsingsoft.system.service;


import org.junit.Assert;

import java.util.List;

import javax.persistence.Transient;


import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.tsingsoft.system.entity.User;
import com.tsingsoft.system.service.UserService;

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
public class UserServiceImplTest{ 

	private UserService userService;

	@Before
	public void before() throws Exception {   
		
		String[] locations = { "classpath:config/Sping-Context.xml","classpath:config/mvc-dispatcher-servlet.xml","classpath:config/Spring-JPA-Hibernate.xml"};
		@SuppressAjWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
		 userService = (UserService) ctx.getBean("userService");
	}
	
	@Test
	public void testFindAll() {
		
		List<User>  userList = null;

		
		try {
			userList = userService.findAll("findAllUsers");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(userList);
	}

	@Test
	public void testCreate() {
		
		User user = new User();
		user.setId(1);
		user.setName("李四");
		user.setAge("12");
		try {
			userService.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEdit() {
		
		User user = new User();
		user.setId(0);
		user.setName("王五");
		user.setAge("12");
		try {
			User userCurr = userService.update(user);
			Assert.assertNotNull(userCurr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery() {
		
		User userEntity = null;

		User user = new User();
		user.setId(0);
		try {
			userEntity = userService.findOne(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(userEntity);
	}
	
	@Test
	@Transient
	public void testDel() throws Exception{
		User user = new User();
		user.setId(1);
		user.setName("张三");
		user.setAge("12");
		try {
			userService.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception();
	}
	
}
