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
		// 获取用户注册时表单提交的参数信息
		String name = request.getParameter("name");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String email=request.getParameter("email");
		// 将获取的参数封装到注册表单相关的RegisterFormBean类中
		RegisterFormBean formBean = new RegisterFormBean();
		formBean.setName(name);
		formBean.setPassword(password); 
		formBean.setPassword2(password2);
		formBean.setEmail(email);
		// 验证参数填写是否符合要求，如果不符合，转发到register.jsp重新填写
		if(!formBean.validate()){
			System.out.println("invalidate");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/myRegister.jsp").forward(request, response);
			return;
		}
		System.out.println("validate");
		// 参数填写符合要求，则将数据封装到UserBean类中
		User userBean = new User();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setEmail(email);
		// 调用DBUtil类中的insertUser()方法执行添加操作，并返回一个boolean类型的标志
		boolean b = DB_User.getInstance().insert(userBean);
		// 如果返回为false，表示注册的用户已存在，则重定向到register.jsp重新填写
		if(!b){
			request.setAttribute("DBMes", "你注册的用户已存在");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		response.getWriter().print("恭喜你注册成功，3秒钟自动跳转");
		// 将成功注册的用户信息添加到Session中
		request.getSession().setAttribute("userBean", userBean);
		// 注册成功后，3秒跳转到登录成功页面loginSuccess.jsp
		response.setHeader("refresh", "3;url=register_success.jsp");
		//response.sendRedirect("register_success.jsp");
	}
}

