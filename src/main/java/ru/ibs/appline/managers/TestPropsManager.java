package ru.ibs.appline.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropsManager {
    private final Properties properties = new Properties();
    private static TestPropsManager instance = null;

    private TestPropsManager(){
        try{
            properties.load(new FileInputStream("src/main/resources/environment.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static TestPropsManager getInstance(){
        if(instance==null){
            instance=new TestPropsManager();
        }
        return instance;
    }

    public Properties getProperties(){
        return properties;
    }
}
