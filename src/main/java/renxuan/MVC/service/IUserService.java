package renxuan.MVC.service;

import renxuan.MVC.entity.User;

public interface IUserService {
	//µÇÂ¼
	User login(User user);
	//×¢²á
	boolean registerUser(User user);
	}