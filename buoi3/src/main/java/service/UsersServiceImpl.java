package service;

import model.Users;
import repository.UsersDAO;
import repository.UsersDAOImpl;

public class UsersServiceImpl implements UsersService {
	UsersDAO usersDao = new UsersDAOImpl();

	@Override
	public Users login(String username, String password) {
		Users users = this.get(username);
		if (users != null && password.equals(users.getPassWord())) {
			return users;
		}
		return null;
	}

	@Override
	public Users get(String username) {
		return usersDao.get(username);
	}

}
