package com.ui.run;

import com.ui.util.OperHost;
import com.ui.util.ReadProperties;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class TesngRun {

    public void writeHost() throws Exception {
        HashMap<String,String> hostMap = new HashMap<>();
        ReadProperties readProperties = new ReadProperties();
        readProperties.getProperties("base.properties","jiazheng.58.com");
        readProperties.getProperties("base.properties","jiafu.58.com");
        readProperties.getProperties("base.properties","j1.58cdn.com.cn");
        readProperties.getProperties("base.properties","c.58cdn.com.cn");
        HashMap<String,String> hosts = readProperties.propertyMap;
        System.out.println(hosts);
        //这边需求制定host在本地的地址
        OperHost p = new OperHost("？");
        p.reWrite(hosts);
    }
    public static void main(String[] args) throws IOException {

        //想修改本地的host就启动下面方法，不想就注释掉
        //new TesngRun().writeHost();

        //下面就是多线程调用用例了代码了
        TestNG testNG = new TestNG();

        List suites = Lists.newLinkedList();
        suites.add("src/main/resources/testng.xml");
        testNG.setTestSuites(suites);
        testNG.run();
        System.out.println(testNG.getStatus());

    }
}
