package test.org.elsys.ip.rest;

+import static org.junit.Assert.assertEquals;
+import static org.junit.Assert.assertNotNull;
+
+import src.org.elsys.ip.model.Post;
import src.org.elsys.ip.rest.*;
+import org.junit.Before;
+import org.junit.Test;
+
+/**
+ * For unit testing you can use JUnit or TestNG
+ */
+public class PostRestTest {
+	private PostsRest postsRest;
+
+	@Before
+	public void setUp() throws Exception {
+		postsRest = new PostsRest();
+	}
+
+	@Test
+	public void testSetAuthor() {
+		final Post post = new Post();
+		post.setTitle("hello");
+		post.setBody("world");
+		
+		final Post result =
+			postsRest.createPost(post);
+		
+		assertNotNull(result.getUser());
+		assertEquals("hello@world", result.getUser().getEmail());
+		assertEquals("secret", result.getUser().getPassword());
+	}
+	
+	// TODO add more tests
+}