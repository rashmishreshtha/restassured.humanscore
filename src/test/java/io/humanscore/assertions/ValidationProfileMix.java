package io.humanscore.assertions;

import io.humanscore.interfaces.IValidation;
import io.restassured.response.Response;
import org.testng.Assert;
import io.humanscore.common.Schema;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ValidationProfileMix implements IValidation {

    @Override
    public void checkStatus(Response resp, int code) {
        Assert.assertEquals(resp.statusCode(), code);
    }

    @Override
    public void schema(Response resp, String path) {
        try {
            InputStream file = new FileInputStream(path);
            Assert.assertEquals(resp.statusCode(), path);
        }catch(Exception exp){
            System.out.println(exp.getMessage());
        }
    }

    @Override
    public void sla(Response resp, long time) {
        Assert.assertTrue(resp.getTime() < time);
    }
}
