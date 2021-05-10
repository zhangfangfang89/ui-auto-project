package com.ui.base;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * <pre>
 *      业务描述：
 * </pre>
 *
 * @author mac
 * @since 2021/5/9 11:21
 */

@Test
public class UiTestBase {
    public AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        //判断appiumserver是否开启，没开启就开启，有开启就不做什么动作
//        读取配置文件来设置driver
        //判断是唤起哪个app后走不同的分支 进行登录后进入家服的入口页面
    }

    @AfterMethod
    public void tearDown() {
        //关闭driver
    }
}
