package fullstack.finalProject;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class TestExamples {

    @Test
    public void test_1() {
        Response response = get("https://reqres.in/api/users?page=2");

        int status_code = response.getStatusCode();

        Assert.assertEquals(status_code, 200);
    }

    @Test
    public void test_2() {
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].id", equalTo(8));
    }
}
