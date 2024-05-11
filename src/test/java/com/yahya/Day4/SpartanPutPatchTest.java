package com.yahya.Day4;

import com.yahya.utility.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SpartanPutPatchTest extends SpartanTestBase {

    /**
     * PUT /spartans/{id}
     * content type is JSON
     * body is
     * {
     *     "name": "API POST",
     *     "gender": "Male",
     *     "phone": 1231231234
     * }
     * Expecting a 204
     */

    @Test
    public void testUpdate(){

        String updatedBody = "{\n" +
                "          \"name\": \"New Body\",\n" +
                "          \"gender\": \"Male\",\n" +
                "          \"phone\": 5555555555\n" +
                "      }";

        given()
                .log().all()
                .pathParams("id", 5)
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .put("spartans/{id}")
                .then()
                .log().all()
                .statusCode(equalTo(204));

    }

    @Test
    public void testPartialUpdate(){

        /**
         * PATCH(Partial Update) /spartans/{id}
         * content type is JSON
         * body is
         * {
         *     "name": "Updated Name"
         * }
         * Expecting a 204
         */

        String updatedBody = "{\"name\": \"Updated Name\"\n" + "}";

        given()
                .log().all()
                .pathParams("id", 5)
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .patch("spartans/{id}")
                .then()
                .log().all()
                .statusCode(equalTo(204));
    }

    @Test
    public void testDelete(){

        /**
         * DELETE /spartans/{id}
         */

        given()
                .log().all()
                .pathParams("id", 10)
                .when()
                .delete("/spartans/{id}")
                .then()
                .log().all()
                .statusCode(204);


    }

}
