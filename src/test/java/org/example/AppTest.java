package org.example;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppTest
{
    @Test
    public void testPOST()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        JSONObject r = new JSONObject();
        r.put("PostId", 1);
        r.put("name", "Jigar");
        r.put("email", "jigar.7195@gmail.com");
        r.put("date", formatter.format(date));
        System.out.println(r.toJSONString());
        baseURI = "https://jsonplaceholder.typicode.com";
        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(r.toJSONString())
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
                .body("name", equalTo("Jigar"))
                .body("PostId", equalTo(1))
                .body("email", equalTo("jigar.7195@gmail.com"))
                .body("date", equalTo("2023-05-21"))
                .time(Matchers.lessThan(2500L))
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Content-Length", "108")
            .log()
            .all();

    }
}
