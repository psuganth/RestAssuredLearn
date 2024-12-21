package UsableFiles;

import org.testng.annotations.BeforeMethod;

import io.cucumber.java.Before;
import io.restassured.RestAssured;


public class BaseClass {
    public static String sysID;
    public static String incNum;

    @BeforeMethod
    public void setup(){
        RestAssured.baseURI = "https://dev205639.service-now.com/api/now/table/";
        RestAssured.authentication = RestAssured.basic("admin", "YoD55g@uwL!W");
    }
}
