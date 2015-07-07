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
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/ext-5.1.0/packages/ext-theme-crisp/build/resources/ext-theme-crisp-all.css">  
    <script type="text/javascript" src="<%=basePath%>js/ext-5.1.0/ext-all.js"></script>  
    <script type="text/javascript" src="<%=basePath%>js/ext-5.1.0/packages/ext-theme-crisp/build/ext-theme-crisp.js"></script>  

  </head>
  
  <body>
  
  		${name}
  		<%
  			java.util.HashMap<String,String> map = (java.util.HashMap<String,String>)request.getAttribute( "map" );
  			out.println( " key1: "  + map.get("k1") );
  			out.println( " key2: "  + map.get("k2") ); 
  			
  		 %>
  		 
  		 <h1>静态文件</h1>
  		 <img alt="a" src="<%=basePath%>resources/1.jpg">
  		 
  		 <form action="<%=basePath%>system/HelloWorldController/hello" method="post" >
  		 	<input type="text" name="name"/>  
  		 	<input type="submit" value="提交"/>
  		 </form>
  		 
  		 <script type="text/javascript">
	  		Ext.onReady(function(){  
	  		    Ext.MessageBox.alert('hello','HELLO WORLD!');
  		 </script>
     <br>
  </body>
</html>
