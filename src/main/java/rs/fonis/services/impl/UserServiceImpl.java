package rs.fonis.services.impl;

import rs.fonis.dao.UserDao;
import rs.fonis.domain.User;
import rs.fonis.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDao ud;

	public UserServiceImpl() {
		ud = new UserDao();
	}

	public User getUser(int id) {
		return ud.getUser(id);
	}

	public boolean deleteUser(int id) {
		return ud.deleteUser(id);
	}

	public User updateUser(User user) {
		return ud.updateUser(user);
	}

	public User insertUser(User user) {
		return ud.insertUser(user);
	}

}
