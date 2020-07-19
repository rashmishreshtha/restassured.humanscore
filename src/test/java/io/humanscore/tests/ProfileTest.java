package io.humanscore.tests;

import io.humanscore.Authorization;
import io.humanscore.Client;
import io.humanscore.assertions.ValidationProfileMix;
import io.humanscore.common.Config;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest {
	Client cli = new Client("dfsgdsfS");
	Authorization auth = new Authorization();
	@Test
	public void getProfileMix() {
		try {
			Response token = auth.GetAuth(Config.getProperty("user"), Config.getProperty("pwd"));
			JSONObject jo = new JSONObject(token.asString());
			Response resp = cli.get("/profile/mix");
			ValidationProfileMix assertProfileMix = new ValidationProfileMix();
			assertProfileMix.checkStatus(resp, 200);
			assertProfileMix.sla(resp, 5000);
			JSONArray ja = new JSONArray(resp.asString());
			Assert.assertEquals(ja.length(), 12);
			Assert.assertEquals(new JSONObject(ja.get(0).toString()).getString("name"),"Som Sekhar");
		}catch(Exception exp){
			//System.out.println(exp.getMessage());
		}
	}

	@Test
	public void getProfile() {
		try {
			Response token = auth.GetAuth(Config.getProperty("user"), Config.getProperty("pwd"));
			JSONObject jo = new JSONObject(token.asString());
			Response resp = cli.get("/profile/5d559a931b22e01f3a5e6864");
			ValidationProfileMix assertProfileMix = new ValidationProfileMix();
			assertProfileMix.checkStatus(resp, 200);
			assertProfileMix.sla(resp, 5000);
		}catch(Exception exp){
			//System.out.println(exp.getMessage());
		}
	}
}

