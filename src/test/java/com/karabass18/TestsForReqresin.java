package com.karabass18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class TestsForReqresin extends StartSet{


    @Test
    @DisplayName("GET  /api/unknown/2")
    public void apiTest01(){

        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("/api/unknown/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.color", is("#C74375"))
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }

    @Test
    @DisplayName("GET  /api/users/23")
    public void apiTest02(){

        given()
                .log().uri()
                .contentType(JSON)
                .when()
                .get("/api/users/23")
                .then()
                .log().status()
                .log().body()
                .statusCode(404)
                .body(is("{}"));


    }

    @Test
    @DisplayName("POST  /api/users")
    public void apiTest03(){

        String requestData ="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .log().uri()
                .contentType(JSON)
                .body(requestData)
                .when()
                .post("/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));


    }

    @Test
    @DisplayName("PUT  /api/users/2")
    public void apiTest04(){

        String requestData ="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .log().uri()
                .contentType(JSON)
                .body(requestData)
                .when()
                .put("/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("leader"));


    }

    @Test
    @DisplayName("POST  /api/register")
    public void apiTest05(){

        String requestData ="{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        given()
                .log().uri()
                .contentType(JSON)
                .body(requestData)
                .when()
                .post("/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));


    }

}
