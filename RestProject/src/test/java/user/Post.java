package user;

public class Post {
	private int id;
	private String title;
	private String body;
	private int userid;
	
	public Post(int id, String title, String body, int userid) {
		this.id=id;
		this.title=title;
		this.body=body;
		this.userid=userid;
	}
	public Post(String title, String body, int userid) {
		//this.id=id;
		this.title=title;
		this.body=body;
		this.userid=userid;
	}
	
	public int getId() {
		return id;
		
	}
public void setId(int id) {
	this.id=id;

}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title=title;
	
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body=body;
}
public int getUserId() {
	return userid;
}
public void setUserId(int userid) {
	this.userid=userid;
}
}
