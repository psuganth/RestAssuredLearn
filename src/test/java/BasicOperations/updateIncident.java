package BasicOperations;

import UsableFiles.BaseClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class updateIncident extends BaseClass {
	
	@Test(dependsOnMethods = "Day1Learns.createInc.create")
	public void updateInc() {
		/*RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "YoD55g@uwL!W");*/
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"description\":\"Some Issue 3 update\",\r\n"
				+ "    \"short_description\":\"Big issue 3 update\"\r\n"
				+ "}");
		Response resp = input.put("incident/"+sysID);
		resp.prettyPrint();
		
	}
}
