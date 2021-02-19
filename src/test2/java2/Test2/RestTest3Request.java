package Test2;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class RestTest3Request {
    public RequestSpecification getCommonSpec() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://reqres.in/");
        builder.setBasePath("api/users?page=2");

        RequestSpecification requestSpec = builder.build();
        return requestSpec;
    }
    @Test
    public void test_01(){
        Response response = RestAssured
                .given()
                .spec(getCommonSpec())
                .when()
                .get();
        response.getBody().prettyPrint();
    }
}
