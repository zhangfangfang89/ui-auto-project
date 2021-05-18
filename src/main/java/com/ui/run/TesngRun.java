package com.ui.run;

import com.ui.util.OperHost;
import com.ui.util.ReadProperties;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class TesngRun {

    public void writeHost() throws Exception {
        ReadProperties readProperties = new ReadProperties();
        readProperties.getProperties("base.properties","jiazheng.58.com");
        readProperties.getProperties("base.properties","jiafu.58.com");
        readProperties.getProperties("base.properties","j1.58cdn.com.cn");
        readProperties.getProperties("base.properties","c.58cdn.com.cn");
        HashMap<String,String> hosts = readProperties.propertyMap;
        System.out.println(hosts);
        //这边需求制定host在本地的地址
        OperHost p = new OperHost("/etc/hosts");
        p.reWrite(hosts);
    }
    public static void main(String[] args) throws IOException {

        ArrayList<String> testXMLDir = new ArrayList<>();
        //加入要跑的tesngxml，需要使用人自己指定
        testXMLDir.add("src/main/resources/testng.xml");

        Thread[] threads = new Thread[testXMLDir.size()];
        for (int i = 0;i < testXMLDir.size();i++){
            RunTestsThead runTestsThead = new RunTestsThead();
            runTestsThead.setSuites(testXMLDir.get(i));
            threads[i]=runTestsThead;
            System.out.println(threads[i]);

        }
        for (Thread thread : threads) {
            thread.start();

        }

    }
}
