package src.org.elsys.ip;

import src.org.elsys.ip.service.PostService;;
/**
 * This is used instead of injection.
 * Injection should be used in real projects.
 * see https://github.com/google/guice
 */
public class Service {

	private static PostService postsService;

	// TODO synchronized should be done in better way in real projects
	public synchronized static PostService getPostsService() {
		// lazy loading
		if (postsService == null) {
			postsService = new PostService();
		}
		return postsService;
	}
	
	// for tests purposes
	static void setPostsService(PostService postsService) {
		Service.postsService = postsService;
	}
}
