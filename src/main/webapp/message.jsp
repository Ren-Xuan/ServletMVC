<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<% 
				Object msg = session.getAttribute("message");//创建信息对象，并获取当前session会话的message属性
			   		if(msg!="" && msg!=null){ 			//判断信息对象是否为空
			%>
				<script>
					alert("<%=msg%>");
					window.location.href="login.jsp";//确定后，跳转到登录页面
				</script>
			<%		
			   			}	
			%>
</body>
</html>
