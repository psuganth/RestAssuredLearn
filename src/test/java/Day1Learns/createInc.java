package Day1Learns;

import UsableFiles.BaseClass;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createInc extends BaseClass{

	@Test
	public void create() {
		/*
		 * Map<String, String> qp = new HashMap<>(); qp.put("sysparm_fields",
		 * "description,short_description,sys_id");
		 */
		/*RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "YoD55g@uwL!W");*/
		RequestSpecification body = RestAssured.given()
				   .contentType("application/json").when()
		           .body("{\r\n"
		           		+ "    \"description\":\"Some Issue 2\",\r\n"
		           		+ "    \"short_description\":\"Big issue 2\"\r\n"
		           		+ "}");
		Response resp = body.post("incident");
		sysID = resp.jsonPath().getString("result.sys_id");
		System.out.println(sysID);
		resp.prettyPrint();
		resp.then().assertThat().statusCode(Matchers.equalTo(201));
		incNum = resp.jsonPath().getString("result.number");
		
	}
}
