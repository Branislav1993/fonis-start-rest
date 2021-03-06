package rs.fonis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import rs.fonis.database.HibernateUtil;
import rs.fonis.domain.User;

public class UserDao {

	public User getUser(int id) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		User u = (User) session.get(User.class, id);

		session.close();

		return u;
	}

	public User insertUser(User user) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return null;
		}

		User newUser = (User) session.get(User.class, user.getId());
		session.close();

		return newUser;

	}

	public boolean deleteUser(int id) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			User user = (User) session.get(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();

			return false;
		}
	}

	public User updateUser(User user) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return null;
		}

		User newUser = (User) session.get(User.class, user.getId());
		session.close();

		return newUser;

	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers(Integer limit, Integer page) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT u " + "FROM User u";

		Query query = session.createQuery(queryString);

		List<User> users = query.setFirstResult((page - 1) * limit).setMaxResults(limit).list();

		session.close();

		return users;
	}
}
