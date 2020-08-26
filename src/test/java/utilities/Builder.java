package utilities;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Builder {

	static RequestSpecification reqSpec;	
	public static RequestSpecification getBuilder() {
		
		if(reqSpec==null) {
		  PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		  auth.setUserName("sivag918@gmail.com");
		  auth.setPassword("1XPIDg0YqO4ZyOXrfiF19DCF");
		  reqSpec = new RequestSpecBuilder().setBaseUri("https://sivaganesharumugam.atlassian.net/").setContentType(ContentType.JSON)
				  .setAuth(auth).build();
	}
		return reqSpec;
	}
}
