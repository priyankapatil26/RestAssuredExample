package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RestAssuredExample {

    @Test
    public void getTest(){
        // to get all the get all details or specific detail through ID
        Response response = RestAssured.get("http://localhost:3000/users/");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public  void postTest(){
        // post is to create
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "John");
        jsonObject.put("lastName", "sample");
        jsonObject.put("subjectId", 1);
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/users");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public  void putTest(){
        // put is to update
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Mary");
        jsonObject.put("lastName", "cooper");
        jsonObject.put("subjectId", 2);
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000//users/2");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public  void patchTest(){
        // put is to update
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("lastName", "aaaaa");
        request.body(jsonObject.toJSONString());
        Response response = request.patch("http://localhost:3000///users/4");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public void deleteTest(){
        // delete is to delete
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/users/6");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public void basicAuthTest(){

        RestAssured.baseURI="http://localhost:3000/posts/";
        RequestSpecification request =   RestAssured.given()
                .auth().preemptive().basic("username","password");
        Response response = request.get();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

    }

}
