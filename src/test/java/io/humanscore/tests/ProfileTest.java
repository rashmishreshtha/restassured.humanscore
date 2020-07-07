package io.humanscore.tests;

import io.humanscore.Authorization;
import io.humanscore.Client;
import io.humanscore.assertions.ValidationProfileMix;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest {
	Client cli = new Client();
	Authorization auth = new Authorization();
	@Test
	public void getProfileMix() {
		Response token = auth.GetAuth("rashmi.shreshtha@gmail.com", "pAssword1");
		try {
			JSONObject jo = new JSONObject(token.asString());
			Response resp = cli.get("/profile/mix", jo.getString("token"));
			JSONArray ja = new JSONArray(resp.asString());
			ValidationProfileMix assertProfileMix = new ValidationProfileMix();
			assertProfileMix.checkStatus(resp, 200);
			assertProfileMix.sla(resp, 5000);
			Assert.assertEquals(ja.length(), 12);
		}catch(Exception exp){
			//System.out.println(exp.getMessage());
		}
	}

	@Test
	public void getProfile() {
		Response token = auth.GetAuth("rashmi.shreshtha@gmail.com", "pAssword1");
		try {
			JSONObject jo = new JSONObject(token.asString());
			Response resp = cli.get("/profile/5d559a931b22e01f3a5e6864", jo.getString("token"));
			ValidationProfileMix assertProfileMix = new ValidationProfileMix();
			assertProfileMix.checkStatus(resp, 200);
			assertProfileMix.sla(resp, 5000);
		}catch(Exception exp){
			//System.out.println(exp.getMessage());
		}
	}
}

