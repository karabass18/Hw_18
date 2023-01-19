package com.karabass18;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class TestsForReqresin extends StartSet{


    @Test
    public void apiTest01(){
       //open("");
        System.out.println("++++" + baseURI);
        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("/api/unknown/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.color", is("#C74375"));


    }
}
