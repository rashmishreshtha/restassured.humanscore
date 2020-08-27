package io.humanscore.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.humanscore.Client;
import io.humanscore.classes.Auth;
import io.restassured.response.Response;

public class Profile {
    private String token;
    private String profileid;
    Response resp;
    @Given("^a valid auth token$")
    public void a_valid_auth_token()  {
       token = Authorization.token;
    }

    @When("^post is performed to profile mix$")
    public void post_is_performed_to_profile_mix() {
        Client cli = new Client(token);
        resp = cli.get("/profile/mix");
    }

    @Then("^list of profiles is returned$")
    public void list_of_profiles_is_returned()  {

    }

    @Given("^profileid$")
    public void profileid() {
        profileid = Authorization.profileId;
    }

    @When("^post is performed to profile$")
    public void post_is_performed_to_profile() {
        Client cli = new Client(token);
        resp = cli.get("/profile/" + profileid);
    }

    @Then("^profile info is returned$")
    public void profile_info_is_returned() {

    }
}
