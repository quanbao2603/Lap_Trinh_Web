package service;

import model.Users;

public interface UsersService {
	Users login(String username, String password);
	Users get(String username);
}
