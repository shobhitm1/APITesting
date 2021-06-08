package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//can't use this keyword inside static method
public class utils {
	public RequestSpecification req;
	public ResponseSpecification respec;
	public RequestSpecification requestspecification() throws IOException {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder()
				.setBaseUri(globalProperties("url"))
				.addQueryParam("key","qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
	}
	
	public ResponseSpecification responsespecification() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		respec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return respec;
	}
	
	public static String globalProperties(String Key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Shobhit\\eclipse-workspace\\ApiFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fin);
		return prop.getProperty(Key);

		
	}
}
