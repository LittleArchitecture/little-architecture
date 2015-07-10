package com.tsingsoft.common;


/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：UserException  
* 类描述：  用户异常处理类  
* 创建人：Nick Shang
* 创建时间：2015-7-5 下午4:32:53  
* 修改人：Think  
* 修改时间：2015-7-5 下午4:32:53  
* 修改备注：  
* @version  V1.0 
*
 */
public class UserException extends RuntimeException {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -9062906218420689341L;

	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

	
}
