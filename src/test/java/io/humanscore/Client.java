package io.humanscore;

import com.sun.rmi.rmid.ExecOptionPermission;
import io.humanscore.common.Config;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.humanscore.stepdefs.*;

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

    public void renewToken() {
    }

    public void checkToken(String token) {
        Date currentTime = new Date();
        long diff = Math.abs(currentTime.getTime() - Authorization.tokenCreationTime.getTime());
        try {
            if (diff - 5000 > Long.getLong(Config.getProperty("tokenExpiration"))) {
                renewToken();
            }
        }catch(IOException exp){

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
