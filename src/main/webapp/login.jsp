<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<style>
	
</style>
</head>
<body>
<div id="main">
	<div class="form">
		<form action="LoginServlet" method="post" id="login_form">
			<h1>登录界面</h1><br/>
			<label>账号</label>
			<input type="text" name="username" id="username"/><br/>
			<label>密码</label>
			<input type="text" name="password" id="password"/><br/>
			<input class="go" type="submit" value="登   录"/><br/>
			<input class="go" type="button" value="注   册" onclick="window.location.href='register.jsp'"/>
		</form>
	</div>
</div>
</body>
</html>
