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
import javax.servlet.http.HttpSession;

import renxuan.MVC.entity.User;
import renxuan.MVC.service.IUserService;
import renxuan.MVC.service.UserServiceImpl;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台页面输入的数据
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String message="";//提示信息
		User user = new User(username,pass);//实例化注册对象，并传入参数
		System.out.println(username+"="+pass);
		IUserService userService = new UserServiceImpl();
		HttpSession session=request.getSession();//创建一个session会话，获取当前会话
		//判断注册方法是否返回结果是否为true
		boolean success=false;
		try {
			success=userService.registerUser(user);
		} catch (Exception e) {
			if (e.getCause().getCause() instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException) {//是否是重复添加的异常
				message = "用户名重复！";//首先验证用户是否唯一
				session.setAttribute("message", message);
				response.sendRedirect("register_fail.jsp");
			}else {
				message = "注册失败,请重新注册！";
				session.setAttribute("message", message);
				response.sendRedirect("register_fail.jsp");
			}
		}
		
		if(success) {
			message = "注册成功！";
			session.setAttribute("message", message);//设置提示信息内容
			response.sendRedirect("register_succeed.jsp");//重定向至信息提示页面
		}else {
			message = "注册失败,请重新注册！";
			session.setAttribute("message", message);
			response.sendRedirect("register_fail.jsp");
		}
	}


}
