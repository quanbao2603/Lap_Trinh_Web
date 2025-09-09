package service.interfaces;

import entity.Users;

public interface UsersService {
	Users login(String username, String password);
}	
