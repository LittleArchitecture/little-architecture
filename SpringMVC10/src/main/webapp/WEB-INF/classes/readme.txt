 参数传递-JSON
 	  访问路径：http://localhost:8080/SpringMVC1/system/UserController/get
 	  
文件上传
	 commons-io-1.3.2.jar
	 commons-fileupload-1.2.1.jar
 	  访问路径： http://localhost:8080/SpringMVC1/system/UploadfileController/  （ 分普通上传和 CommonsMultipartResolver两种上传方式）
 	  
WEB.XML
	启动顺序：
		1、context-param；
		2、listener；
		3、filter-mapping；
		4、servelt;
		
Spring与Spring MVC集成
	访问路径： http://localhost:8080/SpringMVC1/system/UserController/get2
	步骤：
		1、web.xml 配置spring；
		2、编写实现接口和接口实现类；
		3、Controller实现；
		
SpringMVC与Spring上下文关系 ： SpringMVC上下文继承于Spring上下文
	访问路径： http://localhost:8080/SpringMVC1/system/UserController/get2
	说明：
		1、 SpringMVC上下文继承于Spring上下文
		2、获取WebApplicationContext
			WebApplicationContext ac1 = WebApplicationContextUtils.getWebApplicationContext( request.getSession().getServletContext() );
			WebApplicationContext ac2 = RequestContextUtils.getWebApplicationContext(request);
		3、SpingContext.xml 中使用import标签,方便文件管理

Spring与Hibernate集成
	访问路径： http://localhost:8080/SpringMVC1/system/UserController/getAllUser
	
Spring与Hibernate集成  基于REST风格实现用户管理
	访问路径： http://localhost:8080/SpringMVC1/system/UserControllerRest/get
	
Spring与Hibernate集成  基于REST风格实现JSON用户显示
	访问路径： http://localhost:8080/SpringMVC1/system/UserControllerRest/{id}/{username}


Spring与Hibernate集成  修正事务管理
	<!-- 启动自动扫描该包下所有的@Controller -->
    <context:component-scan base-package="com.tsingsoft.*.controller" />  

    <!-- spring context配置文件  -->  
    <context:component-scan base-package="com.tsingsoft.">  
        <context:exclude-filter type="regex" expression=".system.*Controller*" />  
    </context:component-scan>  


Spring与Hibernate集成   ---  <!-- 全局错误处理-->
	<!-- 全局错误处理-->  
	<bean id="exceptionResolver" class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">  
	    <property name="defaultErrorView">    
	        <value>/error/error</value>  
	    </property>  
	    
	    <property name="exceptionMappings">
			<props>
				<prop key="java.sql.SQLException">showDBError</prop>
				<prop key="java.lang.RuntimeException">/error/error</prop>
			</props>
		</property>

	    
	    <property name="defaultStatusCode">    
	        <value>500</value>  
	    </property>     
		<property name="warnLogCategory">    
	        <value>org.springframework.web.servlet.handler.SimpleMappingExceptionResolver</value>  
	    </property>     
	</bean>   
	 
	 
	 
Spring与Hibernate集成   ---  <!-- 全局错误处理-->
	<!-- 全局错误处理-->  
	<bean id="exceptionResolver" class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">  
	    <property name="defaultErrorView">    
	        <value>/error/error</value>  
	    </property>  
	    
	    <property name="exceptionMappings">
			<props>
				<prop key="java.sql.SQLException">showDBError</prop>
				<prop key="java.lang.RuntimeException">/error/error</prop>
			</props>
		</property>

	    
	    <property name="defaultStatusCode">    
	        <value>500</value>  
	    </property>     
		<property name="warnLogCategory">    
	        <value>org.springframework.web.servlet.handler.SimpleMappingExceptionResolver</value>  
	    </property>     
	</bean>   
	 