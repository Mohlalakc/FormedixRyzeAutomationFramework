package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public Properties properties;

    public void loadProperties(){
        final  String propertyFilePath = "src/test/resources/properties/default.properties";
        BufferedReader reader;

        try{
            reader = new BufferedReader((new FileReader(propertyFilePath)));
            properties = new Properties();

            try{
                properties.load(reader);
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("default.properties not found at " +propertyFilePath);
        }
    }
}
