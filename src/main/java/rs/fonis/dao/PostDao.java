package rs.fonis.dao;

import java.util.List;

import org.hibernate.Session;

import rs.fonis.database.HibernateUtil;
import rs.fonis.domain.Post;

public class PostDao {

	public Post getPost(int id) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		Post post = (Post) session.get(Post.class, id);

		session.close();

		return post;
	}

	public Post insertPost(Post post) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.save(post);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return null;
		}

		Post newPost = (Post) session.get(Post.class, post.getId());
		session.close();

		return newPost;

	}

	public boolean deletePost(int id) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			Post post = (Post) session.get(Post.class, id);
			session.delete(post);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();

			return false;
		}
	}

	public Post updatePost(Post post) {
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.update(post);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			session.close();
			return null;
		}

		Post newPost = (Post) session.get(Post.class, post.getId());
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
