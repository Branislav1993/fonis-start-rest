package rs.fonis.dao;

import java.util.List;

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

	public User insertUser(User t) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return null;
		}

		User newUser = (User) session.get(User.class, t.getId());
		session.close();

		return newUser;

	}

	public boolean deleteUser(int id) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			User t = (User) session.get(User.class, id);
			session.delete(t);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();

			return false;
		}
	}

	public User updateUser(User t) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return null;
		}

		User newUser = (User) session.get(User.class, t.getId());
		session.close();

		return newUser;

	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		List<User> users = session.createCriteria(User.class).list();

		session.close();

		return users;
	}
}
