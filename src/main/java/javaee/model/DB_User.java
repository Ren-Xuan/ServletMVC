package javaee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class DB_User {
	
	static DB_User instance= null;
	Connection conn;
	public DB_User() {
		init();
	}
	void init() 
	{
		conn = DB_Conn.getConn();
	}
	
	public boolean insert(User u)
	{

		try {
	    	Statement stat=null;
			String name=u.getName();
			String password = u.getPassword();
			String email = u.getEmail();
			stat=conn.createStatement();
			
			//先要查找看是否存在这个用户了，存在了则返回false
			
			
			String sql = "insert into user(username,password,email) values('"+name+"','"+password+"','"+email+"')";
			System.out.println(sql);
			stat.executeUpdate(sql); 
			if(stat!=null){
		    	   stat.close();
		    }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void delete(String id)
	{
		try {
			Statement stat=null;			
			stat=conn.createStatement();
	 		stat.executeUpdate("delete from students where studentNum="+id);
			if(stat!=null){
		    	   stat.close();
		    }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(User u)
	{
		try {
	    	Statement stat=null;
	    	String name=u.getName();
			String password = u.getPassword();
			String email = u.getEmail();
			stat=conn.createStatement();
			String sql = "update user_inf set username="+name+",password='"+password+"',email="+email+"";
			System.out.println(sql);
			stat.executeUpdate(sql);
			if(stat!=null){
		    	   stat.close();
		    }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public Set<User> searchUsers(String username, String password)
	{
		try {		
	    	Statement stat=null;
		    ResultSet rs=null;
		    String sql = "select * from users ";
			stat=conn.createStatement();
			Set<User> users= new HashSet<User>();
	    	if(username==null) username ="";
	    	if(password==null) password ="";
	    	if(username == "")
	    		sql = sql + " where username like '%'"; 
	    	else
	    		sql = sql + " where username = '"+ username + "'";
	    	
	    	if(password == "")
	    		sql = sql + " and password like '%'";  
	    	else
	    		sql = sql + " and password = '" + password + "'";
	    	

	    	
	    	rs = stat.executeQuery(sql);

	    	while(rs.next())
	        {
	        	User user = new User();
	        	user.setName(rs.getString("name"));
	        	user.setPassword(rs.getString("password"));
	        	user.setEmail(rs.getString("role"));

	        	users.add(user);
	        }
		    if(rs!=null){
		    	  rs.close();
		       }
			if(stat!=null){
		    	   stat.close();
		    }
			return users ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//返回实例
	public static DB_User getInstance()
	{
		if(instance == null){
			instance = new DB_User();
		}
		
		return instance;
	}
}
