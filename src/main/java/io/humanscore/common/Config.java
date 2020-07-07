package io.humanscore.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public Properties prop;
    public String baseurl;

    public Config(String path) throws IOException {
        this.prop = getPropertiesFromFile(path);
        this.baseurl = this.prop.getProperty("baseurl");
    }

    public Properties getPropertiesFromFile(String path) throws IOException {
        InputStream file = new FileInputStream(path);
        Properties _prop = new Properties();
        _prop.load(file);
        return _prop;
    }
}
