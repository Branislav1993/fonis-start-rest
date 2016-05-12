package rs.fonis.services.impl;

import rs.fonis.dao.PostDao;
import rs.fonis.domain.Post;
import rs.fonis.services.PostService;

public class PostServiceImpl implements PostService {

	private PostDao pd;

	public PostServiceImpl() {
		pd = new PostDao();
	}

	@Override
	public Post getPost(int id) {
		return pd.getPost(id);
	}

	@Override
	public boolean deletePost(int id) {
		return pd.deletePost(id);
	}

	@Override
	public Post updatePost(Post post) {
		return pd.updatePost(post);
	}

	@Override
	public Post insertPost(Post post) {
		return pd.insertPost(post);
	}

}
