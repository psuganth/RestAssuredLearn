package BasicOperations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class getIncidentWithQP {
    @Test
    public void getIncQP(){
        RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin","YoD55g@uwL!W");
        //this is a get request and body is not mandatory. SO we are giving the query params only in the request
        // specification
        RequestSpecification input = RestAssured.given().queryParam("sysparm_fields","description,short_description,sys_id");
        Response resp = input.get("incident");
        resp.prettyPrint();

    }
}
