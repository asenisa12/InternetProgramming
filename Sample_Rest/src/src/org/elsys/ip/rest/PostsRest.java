package src.org.elsys.ip.rest;

import java.util.List;

import src.org.elsys.ip.model.Post;
import src.org.elsys.ip.model.User;
import src.org.elsys.ip.service.PostService;

public class PostsRest {
	private final PostsService postsService;
	private final User defaultAuthor;
	public PostsRest() {
		postsService = new PostsService();
		
		// TODO should be get from session
		defaultAuthor = new User();
		defaultAuthor.setEmail("hello@world");
		defaultAuthor.setPassword("secret");
	}

	public List<Post> getPosts() {
		return postsService.getPosts();
	}
	public Post getPost(long postId) {
		return postsService.getPost(postId);
	}
	public Post createPost(Post post) {
		// TODO set author by user session
		post.setUser(defaultAuthor);
		return postsService.createPost(post);
	}
	public Post updatePost(Post post) {
		return postsService.updatePost(post);
	}
	public void deletePost(long postId) {
		postsService.deletePost(postId);
	}
}