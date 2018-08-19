package abc.utils;

import lombok.Data;
import lombok.extern.java.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
@Log
public class PropertiesManager {

    private PropertiesManager(){

    }

    public static Properties getDataFromPropertyFile() {
        Properties property = new Properties();
        FileInputStream objFile = null;
        try {
            objFile = new FileInputStream("C:\\autotestlesson11\\src\\main\\resources\\prop.properties");
            property.load(objFile);
        } catch (IOException e) {
            log.severe("Can`t read file");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return property;
    }

    public static String getPropertyByKey(String propertyKey){
        return getDataFromPropertyFile().getProperty(propertyKey);
    }
}
