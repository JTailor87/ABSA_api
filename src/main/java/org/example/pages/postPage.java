package org.example.pages;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class postPage {
    private static Response response;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    JSONObject r = new JSONObject();

    public void userHasBaseUri(String uri){
        baseURI = uri;
    }
    public void sendPostRequest(String endPoint){
        r.put("PostId", 1);
        r.put("name", "Jigar");
        r.put("email", "jigar.7195@gmail.com");
        r.put("date", formatter.format(date));
        response = given()
                        .header("Content-Type", "application/json")
                        .body(r.toJSONString())
                    .when()
                        .post(endPoint);
    }
    /*-------- Method = 1 --------*/
    public int validateStatusCode(){
        int statusCode = response.getStatusCode();
        return statusCode;
    }
    /*-------- Method = 2 --------*/
    /*public void validateStatusCode(Integer code){
        response.then().statusCode(code);
    }*/
    public void validateTheResponseTime(Long responseTime){
        response.then().time(Matchers.lessThan(responseTime));
    }
    public void validateHeaderContentType(){
        response.then().header("Content-Type", "application/json; charset=utf-8");
    }
    public void ValidateHeaderContentLength(){
        response.then().header("Content-Length", "108");
    }
    public void validateResponseBody(){
        response.then()
                .body("name", equalTo("Jigar"))
                .body("PostId", equalTo(1))
                .body("email", equalTo("jigar.7195@gmail.com"))
                .body("date", equalTo(formatter.format(date)));
    }

}
