package renxuan.MVC.dao;

import renxuan.MVC.entity.User;

public interface IUserDao {
	//µÇÂ¼
	User find(User user);
	//×¢²á
	boolean registerUser(User user);
}