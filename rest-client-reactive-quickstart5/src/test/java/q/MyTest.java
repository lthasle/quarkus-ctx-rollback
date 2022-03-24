package q;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.specification.RequestSpecification;

@QuarkusTestResource(MyBrokerResource.class)
@QuarkusTest
public class MyTest {

	@Test
	void go_Via_Q() throws Exception {
		
		get(MyController.DOMAIN + "/" + MyController.PATH);
	}
	
	private void get(String operation) {

		RequestSpecification rs = given().contentType(MediaType.APPLICATION_JSON);
		rs.get(operation).then().statusCode(SC_OK);
	}
}
