import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class longRedirectTest {
    @Test
    public void testRestAssured() {

        Response response = given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        int statusCode = response.getStatusCode();
        String name = response.getHeader("Location");
        System.out.println(statusCode);
        System.out.println(name);


        while (statusCode == 200) {
            Response locations = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(name)
                    .andReturn();
            String location1 = locations.getHeader("Location");
            System.out.println(location1);
        }

            System.out.println(200);
        }
    }




