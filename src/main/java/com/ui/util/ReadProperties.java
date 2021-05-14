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
    public HashMap<String, String> propertyMap = new HashMap<String, String>();

    public void getProperties(String name ,String property) throws IOException {
        properties.load(this.getClass().getClassLoader().getResourceAsStream(name));
        String propertyString = this.properties.getProperty(property);
        if(!propertyString.equals("")) {
            propertyMap.put(property, propertyString);
        }
    }


}
