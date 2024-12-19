package BasicOperations;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import UsableFiles.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getIncident extends BaseClass {
	@Test(dependsOnMethods="Day1Learns.createInc.create")
	public void getAllIncidents() {
		/*RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "YoD55g@uwL!W");*/
		/*RequestSpecification body = RestAssured.given().contentType("application/json")
												.when().body(null);*/
		Response resp = RestAssured.get("incident");
		resp.prettyPrint();
		resp.then().assertThat().body("result.number", Matchers.hasItem(incNum));
	}

}
