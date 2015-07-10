<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'HelloWorld.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			//1、添加操作
			$("#add").click(function(){
				
				var name = $("#name").val();
				var age = $("#age").val();
				
				var user = { name:name,age:age };
				
				$.ajax({
					url:'<%=basePath%>/system/UserController/add_json',
					type:"get",
					data:user,
					success:function(data){
						alert( "username->:" + data.name +"; age->:" +data.age );
					}
				});
				 
			});
			
		});
	</script>

  </head>
  
  <body>
  
  		<%
  			if( request.getAttribute( "hashMap" ) != null ){
  				java.util.HashMap<String,String> map = (java.util.HashMap<String,String>)request.getAttribute( "hashMap" );
  	  			out.println( " 用户名: "  + map.get("name") );
  	  			out.println( " 年龄: "  + map.get("age") );	
  			}
  		 %>
  		 
  		 <h1>静态文件</h1>
  		 <img alt="a" src="<%=basePath%>resources/1.jpg">
  		 
  		 <form action="<%=basePath%>/system/UserController/add" method="post" >
  		 	用户名：<input type="text" name="name" id="name" value="11"/><br/>
  		 	年龄：<input type="text" name="age" id="age" value="11" /><br/>  
  		 	<input type="button" id="add" name="add" value="提交"/>
  		 </form>
     <br>
  </body>
</html>
