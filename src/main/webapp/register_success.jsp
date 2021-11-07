<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="javaee.*"%> 
<%@ page import="java.io.*"%>  
<%@ page import="java.util.*"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
<style type="text/css">
        #main {
	        width: 500px;
	        height: auto;
        }
        #main div {
	        width: 200px;
	        height: auto;
        }
        ul {
	        padding-top: 1px;
	        padding-left: 1px;
	        list-style: none;
        }
    </style>
</head>
<body>
	    <%
		    if (session.getAttribute("userBean") == null) {
	    %>
	    <jsp:forward page="myRegister.jsp" />
	    <%
		    return;
		    }
	    %>
	    <div id="main">
		    <div id="welcome">恭喜你，登录成功</div>
             <hr />
		    <div>您的信息</div>
		    <div>
			    <ul>
				    <li>您的姓名:${userBean.name }</li>
				    <li>您的邮箱:${userBean.email }</li>
			    </ul>
		    </div>
	    </div>
</body>
</html>

