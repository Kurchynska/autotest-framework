package abc.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Data
@NoArgsConstructor
public class PropertiesManager {

    public Properties getDataFromPropertyFile() {

        Properties property = new Properties();
        FileInputStream objFile = null;
        try {
            objFile = new FileInputStream("C:\\lesson10\\src\\main\\resources\\prop.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {

            property.load(objFile);

        } catch (IOException e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }
        return property;
    }


}
