package service;

import dao.ProfileDAO;
import entity.UserProfile;

public class ProfileService {
	private final ProfileDAO dao = new ProfileDAO();

    public UserProfile getProfile(int id) {
        return dao.getById(id);
    }

    public void updateProfile(UserProfile profile) {
        dao.saveOrUpdate(profile);
    }
}
