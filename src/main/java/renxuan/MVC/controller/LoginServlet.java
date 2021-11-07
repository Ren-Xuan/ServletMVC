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
		//request��ȡǰ̨ҳ���������Ϣ
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		//����һ��Userʵ��,����ǰ̨��ȡ������Ϊ����
		User user = new User(username,pass);
		//����������󣬵��õ�¼����
		IUserService userService = new UserServiceImpl();
		//��Userʵ����ΪuserService��login�����Ĳ������жϸ�userʵ���Ƿ�������ݿ��С�(����ֵ)
		if(userService.login(user)!=null) {
			//�ض������ɹ�ҳ��
			response.sendRedirect("success.jsp");
		}else {
			//�ض�����ʧ��ҳ��
			response.sendRedirect("fail.jsp");
		}
	}
	
	

}
