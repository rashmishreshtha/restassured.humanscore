package io.humanscore;

import io.humanscore.common.Config;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Client {
	Config cnf;
	public Client() {
		try {
			cnf = new Config("./resources/dev.properties");
		} catch (IOException e) {

		}
	}

	public Response get(String url)  {
		Response resp = RestAssured.given().get(cnf.baseurl + url);
		resp.then().log().all();
		return resp;
	}

	public Response get(String url, String token)  {
		Response resp = RestAssured.given().header("Authorization", token).get(cnf.baseurl + url);
		resp.then().log().all();
		return resp;
	}
	public Response post(String url, Map<String, Object> payload){
		Response resp = RestAssured.given().body(payload).post(cnf.baseurl + url);
		resp.then().log().all();
		return resp;
	}
}
