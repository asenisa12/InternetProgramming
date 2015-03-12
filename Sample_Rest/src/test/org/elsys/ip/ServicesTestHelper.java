package test.org.elsys.ip;

import src.org.elsys.ip.*;
import src.org.elsys.ip.service.PostService;

/**
 * Injection should be used instead
 */
public class ServicesTestHelper {
	public static void setPostsService(PostService postsService) {
		Service.setPostsService(postsService);
	}
}