package repository;

import model.Users;

public interface UsersDAO {
	Users get(String username);
}
