package rs.fonis.services;

import rs.fonis.domain.User;

public interface UserService {

	public User getUser(int id);

	public boolean deleteUser(int id);

	public User updateUser(User user);

	public User insertUser(User user);
}
