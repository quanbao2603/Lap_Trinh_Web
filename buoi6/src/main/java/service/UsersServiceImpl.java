package service;

import dao.UsersDAOImpl;
import dao.interfaces.UsersDAO;
import entity.Users;
import service.interfaces.UsersService;

public class UsersServiceImpl implements UsersService{
	private UsersDAO usersDAO = new UsersDAOImpl();
	@Override
	public Users login(String username, String password) {
		 return usersDAO.findByUsernameAndPassword(username, password);
	}
}