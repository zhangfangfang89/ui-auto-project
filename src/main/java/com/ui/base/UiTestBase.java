package com.ui.base;

import com.ui.util.DriverHolder;
import com.ui.util.StartAppiumServer;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.log4j.Logger;
import org.testng.annotations.*;



/**
 * <pre>
 *      业务描述：用于处理一些跑用例前的动作
 * </pre>
 *
 * @author 张芳芳
 * @since 2021/5/9 11:21
 */



public class UiTestBase {
    public DriverHolder driverHolder;
    public Boolean appiumServerIsRunning;
    public AppiumDriverLocalService appiumDriverLocalService;
    public static Logger log = Logger.getLogger(UiTestBase.class);


    @Parameters({"host","port"})
    @BeforeSuite
    public void setUpSuite(String host,int port) throws Exception {
        log.info("进行启动appiumserver");
        StartAppiumServer startAppiumServer = new StartAppiumServer(port,host);
        appiumDriverLocalService = startAppiumServer.startServer();
        appiumServerIsRunning=true;
    }
    @AfterSuite
    public void tearDownSuite(){
        log.info("进行关闭appiumserver");
        appiumDriverLocalService.stop();
        appiumServerIsRunning=false;
    }

    @BeforeMethod
    @Parameters({"host","port","platformName","deviceName","platformVersion","appPackage","appActivity","uuid","app"})
    public void setUp(String host, int port,String platformName,String deviceName,String platformVersion,String appPackage,String appActivity,String uuid,String app) throws Exception {
        if (appiumServerIsRunning){
            //这边会去掉从哪个页面开始
            log.info("测试开始了");
            driverHolder = new DriverHolder(host,port,platformName,deviceName,platformVersion,appPackage,appActivity,uuid,app);


        }else {
            throw new Exception("appiumServer 还没启动");
        }

    }
   @AfterMethod
   public void tearDown() {
       log.info("测试结束了");
       this.driverHolder.getDriver().close();

  }
}
