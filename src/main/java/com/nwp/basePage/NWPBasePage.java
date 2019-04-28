package com.nwp.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NWPBasePage {

    public static Properties properties;
    public static void readProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream(new File(
                        ".//src//main//resources//nwp.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
