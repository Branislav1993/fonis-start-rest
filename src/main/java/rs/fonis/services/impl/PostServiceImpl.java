package rs.fonis.services.impl;

import rs.fonis.dao.PostDao;
import rs.fonis.domain.Post;
import rs.fonis.services.PostService;

public class PostServiceImpl implements PostService {

	private PostDao pd;

	public PostServiceImpl() {
		pd = new PostDao();
	}

	public Post getPost(int id) {
		return pd.getPost(id);
	}

	public boolean deletePost(int id) {
		return pd.deletePost(id);
	}

	public Post updatePost(Post post) {
		return pd.updatePost(post);
	}

	public Post insertPost(Post post) {
		return pd.insertPost(post);
	}

}
