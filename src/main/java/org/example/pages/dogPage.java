package org.example.pages;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dogPage {
    private static Response response;
    public static String baseURI;

    public void userHasBaseUri(String uri){
        baseURI = uri;
        System.out.println("baseURI: "+baseURI);
    }
    public void retriveThelistOfAllDogBreeds(String endPoint){
        RestAssured.baseURI = baseURI;
        given()
                .header("Content-Type", "application/json")
            .when()
                .get(endPoint)
            .then()
                .statusCode(200)
                .log()
                .body();
    }
    public void verifyIsRetriverBreedPresent(String endPoint){
        RestAssured.baseURI = baseURI;
        given()
                .header("Content-Type", "application/json")
                .when()
                .get(endPoint)
                .then()
                .statusCode(200)
                .body("message.retriever", hasItems("chesapeake", "curly", "flatcoated", "golden"));
    }
    public void retriveThelistOfSubBreedOfRetriver(String endPoint){
        RestAssured.baseURI = baseURI;
        given()
                .header("Content-Type", "application/json")
            .when()
                .get(endPoint)
            .then()
                .statusCode(200)
                .log()
                .body();
    }
    public void retriveTheImageLinkOfSubBreedGolden(String endPoint){
        RestAssured.baseURI = baseURI;
        given()
                .header("Content-Type", "application/json")
            .when()
                .get(endPoint)
            .then()
                .statusCode(200)
                .log()
                .body();
    }
}
