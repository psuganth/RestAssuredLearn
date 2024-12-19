package BasicOperations;

import UsableFiles.BaseClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteIncident extends BaseClass {
	@Test(dependsOnMethods = "Day1Learns.updateIncident.updateInc")
	public void delIncident() {
		/*RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "YoD55g@uwL!W");*/
		Response response = RestAssured.delete("incident/"+sysID);
		//response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}

}
