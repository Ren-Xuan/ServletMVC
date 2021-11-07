package javaee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DB_Conn {
	Connection conn = null;
	static DB_Conn instance = null;
	//构造函数
	DB_Conn() 
	{
		init();
	}
	//初始化函数
	void init() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jpatest?useUnicode=true&amp;characterEncoding=utf-8&amp&useSSL=false"; 
		    String user="root"; 
			String password="password"; 
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	//返回conn
	public static Connection getConn()
	{
		if(instance == null){
			instance = new DB_Conn();
		}
			
		return instance.conn;
	}
	
	
}
