package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public String getBaseURL(String baseUrl) throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        properties.load(fis);
        return properties.getProperty(baseUrl);
    }

}
