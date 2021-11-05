package com.bridgelabz.restassured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssuredMethods {

    @Test
    public void getMethod() {
        given().
                header("Content-Type", "application/json").
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200);
    }

    @Test
    public void postMethod(){
        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job","Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201);
    }

    @Test
    public void putMethod(){
        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job","Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200);
    }

    @Test
    public void deleteMethod(){
        when().
                delete("https://reqres.in/api/users/2").
        then().
                statusCode(204);

    }

}
