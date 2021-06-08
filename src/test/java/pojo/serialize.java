package pojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class serialize {
	public static void main(String[] args) {
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		mainLocation p = new mainLocation();//addplace=mainLocation
		p.setAccuracy(50);
		p.setAddress("291 P.L. Sharma Road ,Meerut");
		p.setLanguage("English");
		p.setName("Shobhit");
		p.setPhone_number("01212667994");
		p.setWebsite("www.google.co.in");
		List<String> al = new ArrayList<String>();
		al.add("shoe park");
		al.add("agarna vihar");
		p.setTypes(al);
		location l = new location();
		l.setLat(-25.249999);
		l.setLng(-90.12111);
		p.setLocation(l);
		
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
				.setContentType(ContentType.JSON).build();
		
		ResponseSpecification respec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification res=given().spec(req)
		.body(p);
		
		String response=res.when().post("/maps/api/place/add/json")
		.then().spec(respec)
		.extract().response().asString();
		
		
		
	
		
		System.out.println(response);
	}

}
