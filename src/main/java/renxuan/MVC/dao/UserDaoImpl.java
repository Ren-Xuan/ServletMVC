package renxuan.MVC.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import renxuan.MVC.entity.User;

public class UserDaoImpl implements IUserDao{
		//��ʼ��Ԥ������󣬽���������ݿ�����
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Connection conn = null;
		//���߰��е����ݿ����ӷ���
		MyConnection db = new MyConnection();
	@Override
	//��¼
	public User find(User user) {
		//��ȡ����
		conn = db.getConnection();
		String sql = "select * from user where username=? and password=?";
	try {
		//	Ԥ����sql
		pstm = conn.prepareStatement(sql);
		//��ֵռλ��
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());
		//���½����
		rs = pstm.executeQuery();
		while(rs.next()) {
			//�鵽�ö�����ֱ�ӷ��ض��󣬷�����null
			return user;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		//�ͷ���Դ
		release();
	}
	
	return null;
}

	@Override
	//ע��
	public boolean registerUser(User user) {
		//��ȡ����
		conn = db.getConnection();
		String sql = "insert into user(username,password) values(?,?)";
	try {
		//	Ԥ����sql
		pstm = conn.prepareStatement(sql);
		//��ֵռλ��
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());
		//�������ݿ�
		pstm.executeUpdate();
		//ע����ϣ�����true
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return false;
}
	//�Ⱥ��ͷŽ������Ԥ���룬���ݿ�������Դ
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
