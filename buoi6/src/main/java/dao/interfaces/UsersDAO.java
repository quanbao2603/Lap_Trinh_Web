package dao.interfaces;

import entity.Users;

public interface UsersDAO {
	Users findByUsernameAndPassword(String username, String password);
}