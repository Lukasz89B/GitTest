package Test2;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static net.bytebuddy.matcher.ElementMatchers.isEquals;
import static org.hamcrest.core.IsAnything.anything;

public class RestTest2Response {

    public ResponseSpecification ResponseSpecification() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);

        ResponseSpecification responseSpecification = builder.build();
        return responseSpecification;
    }
    @Test
    public void test_with(){
        String url = "https://reqres.in/api/users?page=2";

        RestAssured
                .when()
                .get(url)
                .then()
                .spec(ResponseSpecification());
    }
    @Test
    public void test_without(){
        String url = "https://reqres.in/api/users?page=2";

        RestAssured
                .when()
                .get(url)
                .then()
                .spec(ResponseSpecification())
                .log().body();
    }
}
