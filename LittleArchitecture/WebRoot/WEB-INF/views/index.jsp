

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html manifest="<%=basePath%>/js/ext_5_1_0/">
<head>
 	<base href="<%=basePath%>/js/ext_5_1_0/">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">

    <title>DEMO</title>


	<link type="text/css" rel="stylesheet" href="<%=basePath%>/js/ext_5_1_0/css/font-awesome.css">  
 
    <!-- The line below must be kept intact for Sencha Cmd to build your application -->
    <script id="microloader" type="text/javascript" src="<%=basePath%>/js/ext_5_1_0/bootstrap.js"></script>

</head>
<body></body>
</html>
