package stepdefinitions;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.location;
import pojo.mainLocation;
import resources.TestDataBuild;
import resources.utils;

public class stepDefinitions extends utils {
	TestDataBuild testd = new TestDataBuild();
	RequestSpecification res;
	//ResponseSpecification respec;
	Response response;
	@Given("Add Place Payload")
	public void add_place_payload() throws FileNotFoundException {
		
		System.out.println("--Inside Given--");
		 res=given().spec(requestspecification())
		.body(testd.getData());
	}
	
	@When("user calls {string} Payload with Post Request")
	public void user_calls_payload_with_post_request(String string) {
			System.out.println("--Inside When--");
			
			response=res.when().post("/maps/api/place/add/json")
					.then().spec(responsespecification())
					.extract().response();
	}
	
	@Then("API call is success with status code as {int}")
	public void api_call_is_success_with_status_code_as(Integer int1) {
		assertEquals(response.getStatusCode(),200);	
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expected) {
	    String reso=response.asString();
	    JsonPath js = new JsonPath(reso);
	    assertEquals(js.get(key).toString(),expected);
	    System.out.println(expected);
	  }
	
}
