package renxuan.MVC.dao;

import renxuan.MVC.entity.User;

public interface IUserDao {
	//��¼
	User find(User user);
	//ע��
	boolean registerUser(User user);
}