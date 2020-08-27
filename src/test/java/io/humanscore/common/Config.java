package io.humanscore.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static Properties prop;
    public static String file;

    public static void getPropertiesFromFile(String path) throws IOException {
        InputStream file = new FileInputStream(path);
        prop = new Properties();
        prop.load(file);
    }

    public static String getProperty (String str) throws IOException{
        if (prop == null)
            getPropertiesFromFile("./resources/dev.properties");
        return prop.getProperty(str);
    }
}
