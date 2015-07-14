package com.tsingsoft.system.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@NamedQuery(
        name="findAllUsers",
        query="SELECT c FROM User c"
)

/**
 * 
*   
* 项目名称：SpringMVC9  
* 类名称：User  
* 类描述：  用户类
* 创建人：Think  
* 创建时间：2015-6-24 下午4:48:09  
* 修改人：fchao Zhai  
* 修改时间：2015-7-14 下午4:31:26  
* 修改备注：    
* @version   
*
 */
@Entity
@Table(name = "t_users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 2491292855748597840L;

	
	 
	@Id
	/**
	 * 主键
	 */
	private long id;
	

	@Column(name="name",length=32)
	@NotNull(message="不能为空")
	@NotEmpty(message="不能为空")
	@Size(min=2,max=100,message="用户名长度大于2")
	
	/**
	 *姓名
	 */
	private String name;

	
	@Column(name="age",length=32)  
	@NotNull(message="不能为空")
	@NotEmpty(message="不能为空")
	/**
	 * 年级
	 */
	private String age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
