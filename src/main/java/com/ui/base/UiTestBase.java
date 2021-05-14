package com.ui.base;

import com.ui.util.InitDriver;
import com.ui.util.StarAppiumServer;
import io.appium.java_client.AppiumDriver;
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
    public AppiumDriver driver;
    public Boolean appiumServerIsRunning;
    public AppiumDriverLocalService appiumDriverLocalService;
    public static Logger log = Logger.getLogger(UiTestBase.class);

    @Parameters({"host","port"})
    @BeforeSuite
    public void setUpSuite(String host,int port) throws Exception {
        log.info("进行启动appiumserver");
        StarAppiumServer starAppiumServer = new StarAppiumServer(port,host);
        appiumDriverLocalService = starAppiumServer.starServer();
        appiumServerIsRunning=true;
    }
    @AfterSuite
    public void tearDownSuite(){
        log.info("进行关闭appiumserver");
        appiumDriverLocalService.stop();
        appiumServerIsRunning=false;
    }

//    @BeforeMethod

//    public void setUp() throws Exception {
//        if (appiumServerIsRunning){
//
//
//            //driver= InitDriver();
//            //这边会去掉从哪个页面开始
//        }else {
//            throw new Exception("appiumServer 还没启动");
//        }
//        //判断appiumserver是否开启，没开启就开启，有开启就不做什么动作
//        // 读取配置文件来设置driver
//        //判断是唤起哪个app后走不同的分支 进行登录后进入家服的入口页面
//    }
//   @AfterMethod
//   public void tearDown() {
//       //关闭driver
//  }
}
