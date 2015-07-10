<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserControllerRest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<a href="<%=basePath%>system/UserControllerRest/add"> 添加</a>
        <c:forEach items="${user}" var="u">
        	用户ID：${u.id} -->	用户名：${u.name}-->  年龄：${u.age} --> <a href="<%=basePath%>/system/UserControllerRest/${u.id}/${u.name}?json">显示</a> --》 <a href="<%=basePath%>/system/UserControllerRest/update/${u.id}">修改</a> </br>
        </c:forEach>
  </body>
</html>
