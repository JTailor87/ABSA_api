package org.example;

import io.restassured.RestAssured;
import org.example.payloads.PostPayload;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class PetStore {

    private PostPayload POSTPayload = new PostPayload();

    @Test
    public void testPOST(){
        baseURI = "https://petstore.swagger.io";
        given()
            .header("Content-Type", "application/json")
            .body(POSTPayload.postPayload())
        .when()
            .post("/v2/pet")
        .then()
            .statusCode(200)
            .log()
            .all();
    }
    @Test
    public void testGETByStatus(){
        baseURI = "https://petstore.swagger.io/v2";
        given()
            .header("Content-Type", "application/json")
            .queryParam("status", "available")
        .when()
            .get("/pet/findByStatus")
        .then()
            .statusCode(200)
            .log()
            .all();

    }
    @Test
    public void testGETById(){
        baseURI = "https://petstore.swagger.io/v2";
        given()
            .header("Content-Type", "application/json")
        .when()
            .get("/pet/1234")
        .then()
            .statusCode(200)
            .log()
            .all();
    }
    @Test
    public void testPUT(){
        baseURI = "https://petstore.swagger.io";
        given()
            .header("Content-Type", "application/json")
            .body(POSTPayload.putPayload(9044))
        .when()
            .put("/v2/pet")
        .then()
            .statusCode(200)
            .log()
            .all();
    }
    @Test
    public void testDELETE(){
        baseURI = "https://petstore.swagger.io/v2";
        given()
            .header("Content-Type", "application/json")
        .when()
            .delete("/pet/1234")
        .then()
            .statusCode(200)
            .log()
            .all();
    }
    @Test
    public void testPOSTUsingExternalJsonFile() throws FileNotFoundException {
        File f = new File("src/test/resources/data.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        baseURI = "https://petstore.swagger.io";
        given()
                .header("Content-Type", "application/json")
                .body(data.toString())
        .when()
                .post("/v2/pet")
        .then()
                .statusCode(200)
                .log()
                .all();
    }
}
