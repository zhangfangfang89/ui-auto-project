package com.ui.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
/**
 * <pre>
 *      业务描述：用于启动读取properties
 * </pre>
 *
 * @author zhangfangfang
 * @since 2021/5/9 17:04
 */
public class ReadProperties {
   private  Properties properties = new Properties();


    public Object getProperties(String name ,String property) throws IOException {
        HashMap<String, String> desiredCapabilitiesMap = new HashMap<String, String>();
        properties.load(this.getClass().getClassLoader().getResourceAsStream(name));
        String propertyString = this.properties.getProperty(property);
        if("base.properties"==name) {


            String[] everyCapabily = propertyString.split(",");

            for (int i = 0; i < everyCapabily.length; i++) {

                desiredCapabilitiesMap.put(everyCapabily[i], everyCapabily[i]);
            }
        }else {
             return propertyString;
        }

        return desiredCapabilitiesMap;
    }

    public static void main(String[] args) throws IOException {
        new ReadProperties().getProperties("base.properties","one.desiredCapabilities");
    }
}
