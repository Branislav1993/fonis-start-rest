package rs.fonis.services;

import rs.fonis.domain.Post;

public interface PostService {

	public Post getPost(int id);

	public boolean deletePost(int id);

	public Post updatePost(Post post);

	public Post insertPost(Post post);

}
