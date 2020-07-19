package io.humanscore.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.humanscore.Client;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Authorization {
	List<Map<String, Object>> logininfo;
	Response resp;
	public static String token;
	
	@Given("^login information is provided$")
	public void login_information_is_provided(DataTable args2) {
		logininfo = args2.asMaps(String.class, Object.class);
	}

	@When("^post is performed to create auth$")
	public void post_is_performed_to_create_auth()  {
		Client cl = new Client();
		resp = cl.post("/auth", logininfo.get(0));
	   
	}

	@Then("^auth is created$")
	public void auth_is_created() {
		Assert.assertEquals(resp.statusCode(), 200);
		JSONObject oauth = new JSONObject(resp.asString());
		token = oauth.getString("token");
	}
}
