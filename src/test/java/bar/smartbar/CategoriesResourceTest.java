package bar.smartbar;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


@QuarkusTest
class CategoriesResourceTest {
    @Test
    void getsListOfCategories() {
        final Response response = given()
                .when().get("/categories")
                .then()
                .statusCode(200)
                .extract().response();
        final JsonPath jsonPath = response.jsonPath();

        Assertions.assertEquals("drinks", jsonPath.getString("[0].name"));

        System.out.println("Response Body: " + response.asString());
    }

//    @Test
//    void getsListOfCategories() {
//        final Response response = given()
//                .when().get("/categories")
//                .then()
//                .statusCode(200)
//                .extract().response();
//
//        String body = response.asString();
//        System.out.println("Response Body: " + body);
//
//        // Έλεγχος ότι περιέχει το όνομα "drinks"
//        Assertions.assertTrue(body.contains("name: drinks"), "Το body δεν περιέχει 'name: drinks'");
//
//        // Προαιρετικά: Έλεγχος ότι ξεκινάει με '[class Category'
//        Assertions.assertTrue(body.startsWith("[class Category"), "Δεν ξεκινάει με αναμενόμενο format");
//    }


}
