package renxuan.MVC.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import renxuan.MVC.entity.User;

public class UserDaoImpl implements IUserDao{
		//初始化预编译对象，结果集，数据库连接
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection conn = null;
		//工具包中的数据库连接方法
		MyConnection db = new MyConnection();
	@Override
	//登录
	public User find(User user) {
		//获取连接
		conn = db.getConnection();
		String sql = "select * from user where username=? and password=?";
	try {
		//	预编译sql
		pstm = conn.prepareStatement(sql);
		//赋值占位符
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());
		//更新结果集
		rs = pstm.executeQuery();
		while(rs.next()) {
			//查到该对象，则直接返回对象，否则是null
			return user;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//释放资源
		release();
	}
	
	return null;
}

	@Override
	//注册
	public boolean registerUser(User user) {
		//获取连接
		conn = db.getConnection();
		String sql = "insert into user(username,password) values(?,?)";
	try {
		//	预编译sql
		pstm = conn.prepareStatement(sql);
		//赋值占位符
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());
		//更新数据库
		pstm.executeUpdate();
		//注册完毕，返回true
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return false;
}
	//先后释放结果集，预编译，数据库连接资源
	public void release() {
	if(rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(pstm!=null) {
		try {
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(conn!=null) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
