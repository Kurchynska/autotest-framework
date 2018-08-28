package abc.utils;

import lombok.Data;
import lombok.extern.java.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
@Log
public class PropertiesManager {

    private static final String PROPERTY_PATH = "props";

    private PropertiesManager(){

    }

    public static Properties getDataFromPropertyFile() {

        String propertyFile = System.getProperty(PROPERTY_PATH);
        Properties property = new Properties();
        try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream(propertyFile)) {
            property.load(input);
        } catch (IOException e) {
            log.severe(String.format("Can't read file %s", propertyFile));
            e.printStackTrace();
        }
        return property;
    }

    public static String getPropertyByKey(String propertyKey){
        return getDataFromPropertyFile().getProperty(propertyKey);
    }
}
