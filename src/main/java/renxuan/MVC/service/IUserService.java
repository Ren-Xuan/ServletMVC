package renxuan.MVC.service;

import renxuan.MVC.entity.User;

public interface IUserService {
	//��¼
	User login(User user);
	//ע��
	boolean registerUser(User user);
	}