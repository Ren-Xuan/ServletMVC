package renxuan.MVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyConnection {
private static String DRIVER = "com.mysql.jdbc.Driver";//驱动文件
private static String URL = "jdbc:mysql://localhost:3306/jpatest?useUnicode=true&amp;characterEncoding=utf-8&amp&useSSL=false";//数据库本地访问地址
private static String USER = "root";//数据库账号
private static String PASS = "password";//数据库密码
Connection connection = null;//声明数据库连接对象，并初始化
public Connection getConnection() {
	try {
		//加载驱动
		Class.forName(DRIVER);
		//获取数据库连接
		connection = DriverManager.getConnection(URL, USER, PASS);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return connection;
	
}
}
