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
    private boolean auth = false;
    public String token;

    public Client() {
        try {
            baseurl = Config.getProperty("baseurl");
        } catch (IOException e) {

        }
    }

    public Client(String token) {
        try {
            baseurl = Config.getProperty("baseurl");
            auth = true;
            this.token = token;
        } catch (IOException e) {

        }
    }

    public Response get(String url) {
        Response resp;
        if (auth == true) {
            resp = RestAssured.given().header("Authorization", token).get(baseurl + url);
        } else {
            resp = RestAssured.given().get(baseurl + url);
        }
        resp.then().log().all();
        return resp;
    }

    public Response post(String url, Map<String, Object> payload) {
        Response resp;
        if (auth == true) {
            resp = RestAssured.given().header("Authorization", token).body(payload).post(baseurl + url);
        } else {
            resp = RestAssured.given().body(payload).post(baseurl + url);
        }
        resp.then().log().all();
        return resp;
    }
}
