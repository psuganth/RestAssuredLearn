package StepDefinitions;
import java.io.File;

import UsableFiles.BaseClass;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagementSteps{
	public static Response response;
	public static RequestSpecification input;
	public static String sysId;
	public static String incNumber;
	
	@Given("Set the endpoint")
	public void Set_the_endpoint() {
		RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
	}
	
	@And("Set the authentication")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "YoD55g@uwL!W");
	}
	
	@When("Get all the incidents")
	public void get_all_the_incidents() {
		response = RestAssured.get("incident");
	}
	
	@Then("Validate the response code {int}")
	public void Validate_the_response_code(int responseCode) {
		response.then().assertThat().statusCode(responseCode);
	}
	
	@When("create the incident with body {string}")
	public void create_the_incident_with_body(String requestBody) {
		input = RestAssured.given().contentType("application/json").when().body(requestBody);
		response = input.post("incident");
		incNumber = response.jsonPath().getString("result.number");
		sysId = response.jsonPath().getString("result.sys_id");
	}
	
	@When("create incident with file {string}")
	public void create_incident_with_file(String file) {
		File fi = new File("src/test/resources/"+file);
		input = RestAssured.given().contentType("application/json").when().body(fi);
		response = input.post("incident");
	}

    @Then("update the incident with the new {string} and {string}")
    public void updateIncident(String description, String shortDescription) {
    	input = RestAssured.given().contentType("application/json").when().body("{\r\n"
    			+ "    \"description\":\""+description+"\",\r\n"
    			+ "    \"short_description\":\""+shortDescription+"\"\r\n"
    			+ "}");
    	response = input.post("incident");
        System.out.println("Updating incident with Description: " + description + ", Short Description: " + shortDescription);
    }

    @Then("verify the updated {string} and {string}")
    public void verifyUpdatedIncident(String description, String shortDescription) {
        response = RestAssured.get("incident/"+sysId);
        System.out.println("Verifying updated Description: " + description + ", Short Description: " + shortDescription);
    }
}
