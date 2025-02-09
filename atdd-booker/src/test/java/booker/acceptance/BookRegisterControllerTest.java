package booker.acceptance;

import booker.common.AcceptanceTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@DisplayName("Feature: 도서 등록")
public class BookRegisterControllerTest extends AcceptanceTest {
    Logger log = LoggerFactory.getLogger(BookRegisterControllerTest.class);

//    @Test
    @DisplayName("새로운 도서를 등록하면 도서가 등록된다.")
    public void shouldRegisterNewBook() {
        // Given:

        // When:
        Response response = given()
                .basePath("/api/books")
                .contentType(ContentType.JSON)
//                .body(requestBody)
                .when()
                .post();

        // Then:
        response.then()
                .statusCode(201)
                .header("Location", not(emptyOrNullString()))
                .header("Location", matchesPattern(".*/api/resources/\\d+$"));
    }

    @Test
    void dsds() {
        log.info("hello world!!!!!!!!!");
    }

}
