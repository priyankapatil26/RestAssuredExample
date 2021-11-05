package com.bridgelabz.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RestAssuredExample {

    @Test
    public void getMethod() {
        baseURI = "http://localhost:3000/";
        given().
                param("firstName", "Priya").
                get("/users").then().statusCode(200).log().all();

    }

    @Test
    public void postMethod() {
        JSONObject request = new JSONObject();
        request.put("firstName", "John");
        request.put("lastName", "Cooper");
        request.put("subjectId", 1);
        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                    post("/users").
                then().
                    statusCode(201).
                    log().all();
    }

    @Test
    public void putMethod() {
        JSONObject request = new JSONObject();
        request.put("firstName", "Mary");
        request.put("lastName", "Cooper");
        request.put("subjectId", 2);

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                    put("/users/2").
                then().
                    statusCode(200).
                    log().all();
    }

    @Test
    public void patchMethod() {
        JSONObject request = new JSONObject();
        request.put("lastName", "JackMan");

        baseURI = "http://localhost:3000/";
            given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                    patch("/users/4").
                then().
                    statusCode(200).
                    log().all();
    }

    @Test
    public void deleteMethod() {
        baseURI = "http://localhost:3000/";
        when().
                delete("users/2").
                then().
                statusCode(204);
    }
}
