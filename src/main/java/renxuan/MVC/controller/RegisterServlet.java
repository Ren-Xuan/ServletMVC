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
		//��ȡǰ̨ҳ�����������
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		String message="";//��ʾ��Ϣ
		User user = new User(username,pass);//ʵ����ע����󣬲��������
		System.out.println(username+"="+pass);
		IUserService userService = new UserServiceImpl();
		HttpSession session=request.getSession();//����һ��session�Ự����ȡ��ǰ�Ự
		//�ж�ע�᷽���Ƿ񷵻ؽ���Ƿ�Ϊtrue
		boolean success=false;
		try {
			success=userService.registerUser(user);
		} catch (Exception e) {
			if (e.getCause().getCause() instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException) {//�Ƿ����ظ���ӵ��쳣
				message = "�û����ظ���";//������֤�û��Ƿ�Ψһ
				session.setAttribute("message", message);
				response.sendRedirect("register_fail.jsp");
			}else {
				message = "ע��ʧ��,������ע�ᣡ";
				session.setAttribute("message", message);
				response.sendRedirect("register_fail.jsp");
			}
		}
		
		if(success) {
			message = "ע��ɹ���";
			session.setAttribute("message", message);//������ʾ��Ϣ����
			response.sendRedirect("register_succeed.jsp");//�ض�������Ϣ��ʾҳ��
		}else {
			message = "ע��ʧ��,������ע�ᣡ";
			session.setAttribute("message", message);
			response.sendRedirect("register_fail.jsp");
		}
	}


}
