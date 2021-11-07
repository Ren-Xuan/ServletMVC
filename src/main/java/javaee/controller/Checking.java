package javaee.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Checking
 */
@WebServlet("/Checking")
public class Checking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("checking");
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Boolean flag = true;
		String userName = request.getParameter("name");
		String passWord = request.getParameter("password");	
		if(userName == null || passWord == null || userName == "" || passWord == "")
			flag = false;
		else
		{
//			Set<User> sts = DataBaseOperator.getInstance().searchUsers(userName,passWord);
//			if(sts.size() != 1 )
//				flag = false;
		}
		
		if(flag)
			response.sendRedirect("register_success.jsp");
			//response.setHeader("refresh", "3;url=register_success.jsp");
		else
			response.sendRedirect("fail.jsp");
	}

}
