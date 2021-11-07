<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<style type="text/css">
        h3 {
	        margin-left: 100px;
        }
        #outer {
	        width: 750px;
        }
        span {
	        color: #ff0000
        }
        div {
             height:20px;
	        margin-bottom: 10px;
        }
        .ch {
	        width: 80px;
	        text-align: right;
	        float: left;
        }
        .ip {
	        width: 500px;
	        float: left
        }
        .ip>input {
	        margin-right: 20px
        }
        #bt {
	        margin-left: 50px;
        }
        #bt>input {"WebContent/jspExp.jsp"
	        margin-right: 30px;
        }
 </style>
 </head>
<body>              <!--change toServlet,call doPost?-->
	    <form action="RegProc" method="post">    
		    <h3>Register</h3>
		    <div id="outer">
			    <div>
				    <div class="ch" style="text-align: left">name:</div>
				    <div class="ip">
				<input type="text" name="name" value="${formBean.name }" />
				<span>${formBean.errors.name}${DBMes}</span>
				    </div>
			    </div>
			    <div>
				    <div class="ch" style="text-align: left">password:</div>
				    <div class="ip">
					    <input type="password" name="password" />
					    <span>${formBean.errors.password}</span>
				    </div>
			    </div>
			    <div>
				    <div class="ch"style="text-align: left">validate_password:</div>
				    <div class="ip">
					    <input type="password" name="password2" />
					    <span>${formBean.errors.password2}</span>
				    </div>
			    </div>
			    <div>
				    <div class="ch"style="text-align: left">email:</div>
				    <div class="ip">
			<input type="text" name="email" value="${formBean.email }" />
					    <span>${formBean.errors.email}</span>
				    </div>
			    </div>
			    <div id="bt">
				    <input type="reset" value="reset" />
				    <input type="submit" value="register" />
			    </div>
		    </div>
	    </form>
</body>
</html>

