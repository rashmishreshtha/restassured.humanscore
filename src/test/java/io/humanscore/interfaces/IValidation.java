package io.humanscore.interfaces;

import io.restassured.response.Response;

import java.io.FileNotFoundException;

public interface IValidation {

    public void checkStatus(Response resp, int code);

    public void schema(Response resp, String path) throws FileNotFoundException;

    public void sla(Response resp, long time);
}
