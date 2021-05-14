package com.ui.util;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


/**
 * <pre>
 *      业务描述：启动一个appdriver以及各种获取对象的方法和操作
 * </pre>
 *
 * @author zhangfangfang
 * @since 2021/5/9 16:45
 */
public class InitDriver {
    private String url;
    public AppiumDriver driver;

    public InitDriver(String host,int port) {
        this.url = String.format("http://%s:%d/wd/hub",host,port);
    }

    //获取driver
    public Object getDriver(String platformName,String deviceName,String platformVersion,String appPackage,String appActivity) throws MalformedURLException {
        if (platformName.equals("Android")) {
            //读书配置文件进行赋值
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appPackage", appPackage);
            desiredCapabilities.setCapability("deviceName", deviceName);
            desiredCapabilities.setCapability("platformVersion", platformVersion);
            desiredCapabilities.setCapability("appActivity", appActivity);
            desiredCapabilities.setCapability("resetKeyboard", true);
            desiredCapabilities.setCapability("noReset", true);
            desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("automationName", "Uiautomator2");
            driver = new AppiumDriver(new URL(this.url), desiredCapabilities);


            return driver;
        }else {
            //ios
            return null;
        }

    }

    //获取对象的方式以及各个方法待写
    //显示等待对象
    public void LocationElement(By byFor,int second){
           WebDriverWait wait = new WebDriverWait(driver, second);
           WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(byFor));
           System.out.println(webElement);

    }


    public void getElementToClick(By byFor,int second){
       //byfor = By.id("")
        if(second!=0){
            LocationElement(byFor,second);
        }
        driver.findElement(byFor).click();
    }

    public void getElementToSubmit(By byFor,int second){
        //byfor = By.id("")
        if(second!=0){
            LocationElement(byFor,second);
        }
        driver.findElement(byFor).submit();
    }
    public void getElementToClear(By byFor,int second){
        //byfor = By.id("")
        if(second!=0){
            LocationElement(byFor,second);
        }
        driver.findElement(byFor).clear();
    }

    public void getElementToSendKeys(By byFor,String context,int second){
        //byfor = By.id("")
        if(second!=0){
            LocationElement(byFor,second);
        }
        driver.findElement(byFor).sendKeys(context);
    }
    public String getElementText(By byFor,int second){
        //byfor = By.id("")
        if(second!=0){
            LocationElement(byFor,second);
        }
        return driver.findElement(byFor).getText();
    }





    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = null;
        InitDriver app = new InitDriver("127.0.0.1",4723);
        app.getDriver("Android","35c5817f","10","com.wuba","com.wuba.activity.launch.LaunchActivity");
        app.getElementToClick(By.id("WD"), 20);



    }
}