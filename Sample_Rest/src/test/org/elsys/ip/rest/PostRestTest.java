package test.org.elsys.ip.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import src.org.elsys.ip.*;
import src.org.elsys.ip.model.Post;
import src.org.elsys.ip.rest.PostsRest;
import src.org.elsys.ip.service.PostService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * For unit testing you can use JUnit or TestNG
 */
public class PostsRestTest {
	private PostsRest postsRest;
	private PostsService postsService;

	@Before
	public void setUp() throws Exception {
		// errors are hard to find without mocking
		// if PostsService contains bugs - this test will fail
		// no matter that PostsRest implementation is correct
		// so we are mocking PostsService to test just PostsRest implementation
		// and find errors easily
		// unit test, not integration test
		postsService = Mockito.mock(PostService.class);
		
		ServicesTestHelper.setPostsService(postsService);
		postsRest = new PostsRest();
	}

	@Test
	public void testSetAuthor() {
		final Post post = new Post();
		post.setTitle("hello");
		post.setBody("world");
		
//		Mockito.when(postsService.createPost(post)).thenReturn(post);
		// if we need to do something
		Mockito.when(postsService.createPost(post)).
			then(new Answer<Post>() {
			@Override
			public Post answer(InvocationOnMock invocation) throws Throwable {
				final Post result = invocation.getArgumentAt(0, Post.class);
				result.setId(1);
				return result;
			}
		});
		final Post result =
			postsRest.createPost(post);
		
		// check if postsService.createPost() is called
		Mockito.verify(postsService).createPost(post);
		 
		// check if there is other calls 
		Mockito.verifyNoMoreInteractions(postsService);

		assertNotNull(result.getUser());
		assertEquals("hello@world", result.getUser().getEmail());
		assertEquals("secret", result.getUser().getPassword());
	}
	
	// TODO add more tests
}