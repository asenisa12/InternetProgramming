package src.org.elsys.ip.model;


/**
 * Model is copied by http://jsonplaceholder.typicode.com/
 */
public class Post {
	
	private long id;
	private User user;
	private String title;
	private String body;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}