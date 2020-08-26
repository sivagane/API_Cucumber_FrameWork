package stepdefnition;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.APIResources;
import utilities.Builder;
import utilities.PayLoad;

public class StepDefnition {

	RequestSpecification reqSpec;
	Response response;
	static String issueid;

	@Given("Add the jira create Api Payload {string} and {string}")
	public void add_the_jira_create_Api_Payload_and(String summary, String description) {
		reqSpec = RestAssured.given().log().all().spec(Builder.getBuilder())
				.body(PayLoad.createIssue(summary, description));
	}

	@When("User should call the {string} with {string} request")
	public void user_should_call_the_with_request(String resource, String reqType) throws ParseException {
		APIResources apiResources = APIResources.valueOf(resource);
		String resourceName = apiResources.getResource();

		if (reqType.equals("Get")) {
			response = reqSpec.when().get(resourceName);
		} else if (reqType.equals("Post")) {
			response = reqSpec.when().post(resourceName);
			JSONParser p = new JSONParser();
			JSONObject o = (JSONObject) p.parse(response.getBody().asString());
			issueid = (String) o.get("key");
			System.out.println(issueid);
		} else if (reqType.equals("Put")) {
			response = reqSpec.when().put(resourceName + "/" + issueid);
		} else if (reqType.equals("Delete")) {
			response = reqSpec.when().delete(resourceName + "/" + issueid);
		} else {
			System.err.println("Not Matched........");
		}
	}

	@Then("User should verify whether the response code is {int}")
	public void user_should_verify_whether_the_response_code_is(int StatusCode) {
		assertEquals("Status Code not Matching", StatusCode, response.getStatusCode());
	}

	@Given("Add the jira update Api Payload {string},{string}")
	public void add_the_jira_update_Api_Payload(String summary, String description) {
		reqSpec = RestAssured.given().log().all().spec(Builder.getBuilder()).body(PayLoad.updateIssue());
	}

	@Given("Add the jira baseUri")
	public void add_the_jira_baseUri() {
		reqSpec = RestAssured.given().log().all().spec(Builder.getBuilder());
	}


}
