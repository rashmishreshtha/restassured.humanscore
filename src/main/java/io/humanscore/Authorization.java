package io.humanscore;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Authorization {
    Client cli = new Client();
    public Response GetAuth(String user, String password) {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("password", password);
        payload.put("user", user);
        Response auth = cli.post("/auth", payload);
        return auth;
    }
}
