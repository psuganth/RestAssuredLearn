package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class cucumberHooks {
	
	@Before
	public void setup(){
        RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "YoD55g@uwL!W");
    }
	
	@After
	public void completeTest(){
        System.out.println("Test Completed");
    }
}

