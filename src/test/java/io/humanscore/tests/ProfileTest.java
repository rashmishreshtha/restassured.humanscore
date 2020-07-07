package io.humanscore.tests;

import io.humanscore.Authorization;
import io.humanscore.Client;
import io.humanscore.interfaces.IAuth;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ProfileTest {
	Client cli = new Client();
	Authorization auth = new Authorization();
	@Test
	public void getProfileMix() {
		Response token = auth.GetAuth("rashmi.shreshtha@gmail.com", "pAssword1");
		JSONObject jo = new JSONObject(token.asString());
		try {
			Response resp = cli.get("/profile/mix", jo.getString("token"));
		}catch(Exception exp){
			System.out.println(exp.getMessage());
		}
	}
}

