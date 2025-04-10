package bar.smartbar;

import bar.smartbar.api.CategoriesResource;
import bar.smartbar.api.model.Category;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static io.restassured.RestAssured.given;


@QuarkusTest
class CategoriesResourceTest {


    @InjectMock
    CategoriesService categoriesServiceMock;

    @BeforeEach
    void setUp() {
        Mockito.when(categoriesServiceMock.get()).thenReturn(new Category().name("Mock"));
    }

    @Test
    void getsListOfCategories() {
        final Response response = given()
                .when().get("/categories")
                .then()
                .statusCode(200)
                .extract().response();
        final JsonPath jsonPath = response.jsonPath();

        Assertions.assertEquals("drinks", jsonPath.getString("[0].name"));
//        Assertions.assertEquals("Mock", jsonPath.getString("[0].name"));

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
