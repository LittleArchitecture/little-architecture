package com.tsingsoft.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsingsoft.common.UserException;
import com.tsingsoft.system.entity.User;
import com.tsingsoft.system.service.UserService;



/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：UserControllerRest  
* 类描述：  现实Rest用户管理
* 创建人：Think  
* 创建时间：2015-7-1 下午3:43:52  
* 修改人：Think  
* 修改时间：2015-7-1 下午3:43:52  
* 修改备注：  
* @version   
*
*/

@Controller
@RequestMapping("/system/UserControllerRest")
public class UserControllerRest {
	
	
	 @Resource(name="userService")
	 private UserService userService;
	  
	/**
	 * 功能描述：进入页面
	 * @return
	 */
	@RequestMapping("/get")
	public String get( ModelMap modelMap ){
		modelMap.put( "user" , userService.findAll());
		return "UserRest/User";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(ModelMap modelMap){
		modelMap.put( "user" , new User() );
		return "UserRest/add";
	}
	
	//用户添加操作，POST访问方法
	//REST风格
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add( @Validated User user,  BindingResult br, ModelMap modelMap ){  //BindingResult放置对象以后
		
		if( br.hasErrors() ){
			//检验出现错误,返回添加页面
			return "UserRest/add";
		} 
		
		if( userService.findOne( user.getId() ) != null ){
			userService.update( user );
			
		}else{
			userService.create( user );
		}
		
		return "redirect:/system/UserControllerRest/get";
	}
	
	
	/**
	 * 功能描述：查询用户
	 * @param id  用户ID
	 * @param username 用户名称
	 * @param model 返回对象
	 * @return 视图
	 */
	//REST风格
	@RequestMapping(value="{id}/{username}",method=RequestMethod.GET)
	public String show(@PathVariable long id, @PathVariable String username,  Model model){
		model.addAttribute( "user", userService.findOne( id ) );
		return "UserRest/show";
	}
	
	
	/**
	 * 功能描述：查询用户
	 * @param id  用户ID
	 * @param username 用户名称
	 * @param model 返回对象
	 * @return 视图
	 */
	//REST风格
	@RequestMapping(value="{id}/{username}",method=RequestMethod.GET,params="json")
	@ResponseBody
	public User show(@PathVariable long id, @PathVariable String username ){
		return userService.findOne( id );
	}
	
	/**
	 * 功能描述：更新用户
	 * @param id  
	 * @param modelMap
	 * @return
	 */
	//REST风格
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update( @PathVariable long id, ModelMap modelMap ){
		
		if(  userService.findOne( id ) != null ){
			modelMap.put( "user" , userService.findOne( id ) );
		}else{
			System.out.println( "-------------error:" + "未查询到数据！" );
		}
	
		return "UserRest/update";
	}
	
	
	/**
	 * 功能描述:全局异常处理
	 * @param user  用户对象
	 * @return 视图
	 */
	@RequestMapping(value="/login")
	public String login( User user){
		
		if( user == null  || user.getName() == null ){
			return "UserRest/login";
		}else if(  user.getName().equals( "NICK") ){
			throw new UserException( "用户名不正确！" );
		}
		
		return "UserRest/login";
	}
}
