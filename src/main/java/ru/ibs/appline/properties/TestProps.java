package ru.ibs.appline.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProps {
    private final Properties properties = new Properties();
    private static TestProps instance = null;

    private TestProps(){
        try{
            properties.load(new FileInputStream("src/main/resources/environment.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static TestProps getInstance(){
        if(instance==null){
            instance=new TestProps();
        }
        return instance;
    }

    public Properties getProperties(){
        return properties;
    }
}
