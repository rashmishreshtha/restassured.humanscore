package io.humanscore;

import io.humanscore.common.Config;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Client {
    static String baseurl;

    public Client() {
        try {
            baseurl = Config.getProperty("baseurl");
        } catch (IOException e) {

        }
    }



    public Response get(String url) {
        Response resp = RestAssured.given().get(baseurl + url);
        resp.then().log().all();
        return resp;
    }

    public Response get(String url, String token) {
        Response resp = RestAssured.given().header("Authorization", token).get(baseurl + url);
        resp.then().log().all();
        return resp;
    }

    public Response post(String url, Map<String, Object> payload) {
        Response resp = RestAssured.given().body(payload).post(baseurl + url);
        resp.then().log().all();
        return resp;
    }
}
