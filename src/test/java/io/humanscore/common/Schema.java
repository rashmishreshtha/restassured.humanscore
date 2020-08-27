package io.humanscore.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Schema {
    public static InputStream read(String path){
        InputStream is = null;
        try {
            is = new FileInputStream(path);
        }catch(Exception exp){

        }
        return is;
    }

}
