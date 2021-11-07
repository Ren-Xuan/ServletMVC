package renxuan.MVC.service;

import renxuan.MVC.dao.IUserDao;
import renxuan.MVC.dao.UserDaoImpl;
import renxuan.MVC.entity.User;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {

		return userDao.find(user);
	}

	@Override
	public boolean registerUser(User user) {

		return userDao.registerUser(user);
	}

	

}
