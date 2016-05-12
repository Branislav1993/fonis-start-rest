package rs.fon.tests;

import org.hibernate.Session;

import rs.fonis.database.HibernateUtil;
import rs.fonis.domain.User;

public class Test1 {

	public static void main(String[] args) {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		User u = (User) session.get(User.class, 1);
		System.out.println(u);
		
//		List<Post> posts = session.createCriteria(Post.class).list();
//		
//		for (Post p : posts) {
//			System.out.println(p);
//		}

		session.close();

	}
}
