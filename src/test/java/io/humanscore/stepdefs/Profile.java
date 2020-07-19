package io.humanscore.stepdefs;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.humanscore.Client;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class Profile {
    List<Map<String, Object>> reginfo;
    Response resp;
    @Given("^registration information$")
    public void registration_information(DataTable arg1)  {
        reginfo = arg1.asMaps(String.class, Object.class);
    }

    @When("^post is performed$")
    public void post_is_performed(){
        Client cl = new Client();
        resp = cl.post("/user", reginfo.get(1));
    }

    @Then("^profile is created$")
    public void profile_is_created(){
        //System.out.println(resp.asString());
    }
}
