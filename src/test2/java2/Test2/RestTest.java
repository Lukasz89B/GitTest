package Test2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class RestTest {

    @Test
    public void test_01(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");

        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void test_02(){

        given()
                .get("https://reqres.in/api/unknown/2")
        .then()
                .statusCode(200);
    }
    @Test
    public void test_03(){
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("name", "morpheus");
        json.put("job", "leader");

        request.body(json.toString());
        Response response = request.post("https://reqres.in/api/users");

        int code = response.getStatusCode();
        Assert.assertEquals(201, code);
    }
    @Test
    public void test_04_post(){
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        request.put("password", "pistol");

        baseURI = "https://reqres.in/api/register";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toString()).
        when().
                post(baseURI).
        then().
                statusCode(200).
                log().all();


    }
}
