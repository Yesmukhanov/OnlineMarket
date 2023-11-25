package FullStack.FinalProject;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class IntegrationTests {

    @Test
    public void CategoryTest() {
        baseURI = "http://localhost:8080/";

        given()
                .get("category").
                then().
                statusCode(200)
                .body("id", hasItems(1, 2))
                .log()
                .all();
    }

    @Test
    public void oneCategoryTest() {

        baseURI = "http://localhost:8080/";

        given().
                get("category/2")
                .then().
                statusCode(200).
                body("id", equalTo(2)).
                body("name", equalTo("q")).
                log().
                all();
    }
}
