package rs.fonis.dao;

import java.util.List;

import org.hibernate.Session;

import rs.fonis.database.HibernateUtil;
import rs.fonis.domain.Post;

public class PostDao {

	public Post getPost(int id) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		Post t = (Post) session.get(Post.class, id);

		session.close();

		return t;
	}

	public Post insertPost(Post t) {
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

		Post newPost = (Post) session.get(Post.class, t.getId());
		session.close();

		return newPost;

	}

	public boolean deletePost(int id) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			Post t = (Post) session.get(Post.class, id);
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

	public Post updatePost(Post t) {
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

		Post newPost = (Post) session.get(Post.class, t.getId());
		session.close();

		return newPost;

	}

	@SuppressWarnings("unchecked")
	public List<Post> getPosts() {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		List<Post> posts = session.createCriteria(Post.class).list();

		session.close();

		return posts;
	}
}
