package renxuan.MVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyConnection {
private static String DRIVER = "com.mysql.jdbc.Driver";//�����ļ�
private static String URL = "jdbc:mysql://localhost:3306/jpatest?useUnicode=true&amp;characterEncoding=utf-8&amp&useSSL=false";//���ݿⱾ�ط��ʵ�ַ
private static String USER = "root";//���ݿ��˺�
private static String PASS = "password";//���ݿ�����
Connection connection = null;//�������ݿ����Ӷ��󣬲���ʼ��
public Connection getConnection() {
	try {
		//��������
		Class.forName(DRIVER);
		//��ȡ���ݿ�����
		connection = DriverManager.getConnection(URL, USER, PASS);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return connection;
	
}
}
