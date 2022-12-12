package com.datdyn.platform.maf.apis;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.json.JSONObject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DashboardResourceTest {

    @ConfigProperty(name = "test-data.url")
    String sxUrl;

    @Test
    @Order(1)
    public void getlicenseDetails_pass() {

        Response response = given()
                .when()
                .get("/api/v1/dashboard/licenseDetails")
                .then().extract()
                .response();
        Assertions.assertEquals(200, response.getStatusCode());

    }


    @Test
    @Order(2)
    public void getAllPolicyStatusDetails_Pass() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");

        Response response = given()
                .headers(headers)
                .when()
                .get("/api/v1/dashboard/policy/status/details")
                .then()
                .extract()
                .response();
        Assertions.assertEquals(200, response.getStatusCode());

        JSONObject responseJsonObject = new JSONObject(response.asString());
        JSONObject policyCountByLastRunStatusJsonObject = (JSONObject) responseJsonObject.get("policyCountByLastRunStatus");
        if(!policyCountByLastRunStatusJsonObject.isNull("Completed")){
            Assertions.assertTrue(Integer.valueOf(String.valueOf(policyCountByLastRunStatusJsonObject.get("Completed"))) >= 0);
        }
        if(!policyCountByLastRunStatusJsonObject.isNull("Failed")){
            Assertions.assertTrue(Integer.valueOf(String.valueOf(policyCountByLastRunStatusJsonObject.get("Failed"))) >= 0);
        }
        if(!policyCountByLastRunStatusJsonObject.isNull("NeverRun")){
            Assertions.assertTrue(Integer.valueOf(String.valueOf(policyCountByLastRunStatusJsonObject.get("NeverRun"))) >= 0);
        }
        if(!policyCountByLastRunStatusJsonObject.isNull("Cancelled")){
            Assertions.assertTrue(Integer.valueOf(String.valueOf(policyCountByLastRunStatusJsonObject.get("Cancelled"))) >= 0);
        }
    }

    @Test
    @Order(3)
    public void getAllProjectDetails_Pass() {
        Response response = given()
                .when()
                .get("/api/v1/dashboard/project/details")
                .then()
                .extract()
                .response();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @Order(4)
    public void getAllOwnerDetails_Pass() {
        Response response = given()
                .when()
                .get("/api/v1/dashboard/owner/details")
                .then()
                .extract()
                .response();
        Assertions.assertEquals(200, response.getStatusCode());
    }
}