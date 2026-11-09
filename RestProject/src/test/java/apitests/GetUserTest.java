package apitests;
import org.testng.annotations.Test;
import user.Post;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetUserTest {

	@Test
	public void getUser() {
		given()
		.header("Content-Type","application/json;charset=UTF-8")
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
		.statusCode(200)
		.body("id",equalTo(1))
		.body("title", notNullValue())
		.log().body();
		
	}
	@Test
	public void deletePost() {
		
		given()
		.when()
		.delete("https://jsonplaceholder.typicode.com/posts/1")
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=1)
	public void createpost() {
		Post p=new Post("java course", "learning rest assured",1);
	given()
	.header("Content-Type","application/json")
	.body(p)
	.when()
		.post("\"https://jsonplaceholder.typicode.com/posts")
		.then()
		.statusCode(201);
	}
}