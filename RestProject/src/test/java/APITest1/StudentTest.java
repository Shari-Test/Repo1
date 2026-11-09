
package APITest1;

import user1.Student;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentTest {

    // GET Student API
    @Test
    public void getStudent1() {

        given()
            .header("Content-Type", "application/json")

        .when()
            .get("http://localhost:3000/students")

        .then()
            .statusCode(200)
            .contentType("application/json")

            // Validate student details
            .body("[0].name", equalTo("John"))
            .body("[0].email", equalTo("john@gmail.com"))
            .body("[0].id", notNullValue())

            // Validate response time
            .time(lessThan(3000L))

            // Validate response headers
            .header("Content-Type", containsString("application/json"))
            .header("Access-Control-Allow-Origin", equalTo("*"))

            .log().all();
    }

    // POST Student API
    @Test
    public void createStudent() {

        Student s = new Student(
            "David",
            "david@gmail.com"
        );

        given()
            .header("Content-Type", "application/json")
            .contentType("application/json")
            .body(s)

        .when()
            .post("http://localhost:3000/students")

        .then()
            .statusCode(201)
            .contentType("application/json")
            .body("name", equalTo("David"))
            .body("email", equalTo("david@gmail.com"))
            .body("id", notNullValue())
            .header("Content-Type", containsString("application/json"))
            .log().all();
    }

    // GET Invalid Student API
    @Test
    public void getInvalidStudent() {

        given()

        .when()
            .get("http://localhost:3000/students/999")

        .then()
            .statusCode(404)
            .contentType("application/json")
            .body("error", equalTo("Not Found"))
            .log().all();
    }
}
