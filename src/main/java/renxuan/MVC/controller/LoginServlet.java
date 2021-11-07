package renxuan.MVC.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import renxuan.MVC.entity.User;
import renxuan.MVC.service.IUserService;
import renxuan.MVC.service.UserServiceImpl;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request获取前台页面的输入信息
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		//创建一个User实例,接受前台获取的数据为参数
		User user = new User(username,pass);
		//创建服务对象，调用登录方法
		IUserService userService = new UserServiceImpl();
		//将User实例作为userService的login方法的参数，判断该user实例是否存在数据库中。(返回值)
		if(userService.login(user)!=null) {
			//重定向至成功页面
			response.sendRedirect("success.jsp");
		}else {
			//重定向至失败页面
			response.sendRedirect("fail.jsp");
		}
	}
	
	

}
