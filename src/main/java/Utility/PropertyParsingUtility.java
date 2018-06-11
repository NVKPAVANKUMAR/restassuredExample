package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyParsingUtility {
    public static Object fecthProperityValues(String key) {
        try {
            FileInputStream input = new FileInputStream("configuration/config.Properties");
            Properties property = new Properties();
            property.load(input);
            return property.getProperty(key);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
