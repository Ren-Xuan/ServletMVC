package javaee.controller;

import java.io.IOException;

import javaee.model.DB_User;
import javaee.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegProc
 */
@WebServlet("/RegProc")
public class RegProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html;charset=GBK");  
		response.setCharacterEncoding("GBK");
		// ��ȡ�û�ע��ʱ���ύ�Ĳ�����Ϣ
		String name = request.getParameter("name");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String email=request.getParameter("email");
		// ����ȡ�Ĳ�����װ��ע�����ص�RegisterFormBean����
		RegisterFormBean formBean = new RegisterFormBean();
		formBean.setName(name);
		formBean.setPassword(password); 
		formBean.setPassword2(password2);
		formBean.setEmail(email);
		// ��֤������д�Ƿ����Ҫ����������ϣ�ת����register.jsp������д
		if(!formBean.validate()){
			System.out.println("invalidate");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/myRegister.jsp").forward(request, response);
			return;
		}
		System.out.println("validate");
		// ������д����Ҫ�������ݷ�װ��UserBean����
		User userBean = new User();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setEmail(email);
		// ����DBUtil���е�insertUser()����ִ����Ӳ�����������һ��boolean���͵ı�־
		boolean b = DB_User.getInstance().insert(userBean);
		// �������Ϊfalse����ʾע����û��Ѵ��ڣ����ض���register.jsp������д
		if(!b){
			request.setAttribute("DBMes", "��ע����û��Ѵ���");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		response.getWriter().print("��ϲ��ע��ɹ���3�����Զ���ת");
		// ���ɹ�ע����û���Ϣ��ӵ�Session��
		request.getSession().setAttribute("userBean", userBean);
		// ע��ɹ���3����ת����¼�ɹ�ҳ��loginSuccess.jsp
		response.setHeader("refresh", "3;url=register_success.jsp");
		//response.sendRedirect("register_success.jsp");
	}
}

