package GetRequest;
import com.jayway.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; 

public class Newtest  
{
	
	//GET request to https://jsonplaceholder.typicode.com/comments
	@Test  
    	public void GetRequetToURL() {
        	Response resp= when().get("https://jsonplaceholder.typicode.com/comments/");
        	System.out.println(resp.getStatusCode());
        	Assert.assertEquals(resp.getStatusCode(), 200,"URL hit success");
    }
	
	//Post with id 40 contains 5 comments
	@Test
		public void Postid40contains5comments() {
			RestAssured.given().
			param("postId","40").
			when().get("https://jsonplaceholder.typicode.com/comments/").
			then().
			assertThat().
			body("size()",equalTo(5));			
}
	//Post with id 40 contains the comments related to id:199
	@Test
		public void CommentTest199() {
        		Response resp=given().
        		param("postId","40").
        		param("id",199).
        		when().get("https://jsonplaceholder.typicode.com/comments/");
        		System.out.println(resp.asString());
        		Assert.assertEquals(resp.getStatusCode(), 200);
    }
}