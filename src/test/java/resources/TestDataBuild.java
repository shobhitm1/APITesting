package resources;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.location;
import pojo.mainLocation;

public class TestDataBuild {
	public mainLocation getData() {
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
		return p;
		}

}
