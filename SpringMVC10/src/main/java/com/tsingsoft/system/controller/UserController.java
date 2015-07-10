package com.tsingsoft.system.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsingsoft.system.entity.User;
import com.tsingsoft.system.service.UserService;

/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：UserController  
* 类描述： 用户管理控制器类 
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:24:34  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:24:34  
* 修改备注：  
* @version  V1.0 
*
 */
@Controller
@RequestMapping( "/system/UserController" )
public class UserController {
	  
	  @Resource(name="userService")
	  private UserService userService;

	 
	  public void setUserService(UserService userService) {
	    this.userService = userService;
	  }

	  @RequestMapping("/toAddUser")
	  public String toAddUser() {
	    return "addUser";
	  }

	  @RequestMapping("/toUpdateUser")
	  public String toUpdateUser(int id, ModelMap modelMap) {
	    User user = userService.findOne(id);
	    modelMap.addAttribute("user", user);
	    return "editUser";
	  }

	  @RequestMapping("/addUser")
	  public String addUser(User user) {
	    userService.create(user);
	    return "redirect:/user/getAllUser";

	  }

	  @RequestMapping("/getAllUser")
	  public String getAllUsers(ModelMap modelMap) {
	    List<User> userList = userService.findAll();
	    modelMap.addAttribute("userList", userList);
	    return "index";

	  }

	  @RequestMapping("/delUser")
	  public String delUser(int id, HttpServletResponse response)
	      throws IOException {
	    User user = userService.findOne(id);
	    System.err.println(user.getName());
	    userService.delete(user);
	    response.getWriter().print("success");
	    return null;
	  }
	  
}
