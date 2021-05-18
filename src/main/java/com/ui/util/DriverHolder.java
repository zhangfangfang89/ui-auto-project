package com.ui.util;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;


/**
 * <pre>
 *      业务描述：启动一个appdriver以及各种获取对象的方法和操作
 * </pre>
 *
 * @author zhangfangfang
 * @since 2021/5/9 16:45
 */
public class DriverHolder {
    private String url;
    private AppiumDriver driver;
    public static Logger log = Logger.getLogger(DriverHolder.class);

    public DriverHolder(String host, int port,String platformName, String deviceName, String platformVersion, String appPackage, String appActivity,String app,String uuid) throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            this.url = String.format("http://%s:%d/wd/hub",host,port);
            if (platformName.equals("Android")) {

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
            }else {
                desiredCapabilities.setCapability("platformName", "ios");
                desiredCapabilities.setCapability("app", app);
                desiredCapabilities.setCapability("deviceName", deviceName);
                desiredCapabilities.setCapability("platformVersion", platformVersion);
                desiredCapabilities.setCapability("uuid", uuid);
                desiredCapabilities.setCapability("usePrebuiltWDA", true);
                desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
                desiredCapabilities.setCapability("automationName", "XCUITest ");

                driver = new AppiumDriver(new URL(this.url), desiredCapabilities);
            }




    }



    //获取对象的方式以及各个方法待写
    //显示等待对象
    public WebElement LocationElement(By byFor,int second){
           WebDriverWait wait = new WebDriverWait(driver, second);
           WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(byFor));

//        MobileElement mobileElement = new AppiumFluentWait<AppiumDriver>(driver)
//                .withTimeout(Duration.ofSeconds(second))
//                .pollingEvery(Duration.ofSeconds(2))
//                .until(new Function<AppiumDriver, MobileElement>() {
//                    @Override
//                    public MobileElement apply(AppiumDriver appiumDriver) {
//                        System.out.println("开始找元素");
//                        MobileElement element = null;
//                        try {
//                            element = (MobileElement) appiumDriver.findElement(byFor);
//                            if (element != null) {
//                                System.out.println(element.getText());
//                            } else {
//                                System.out.println("找不到元素");
//                            }
//                        } catch (Exception exception) {
//                            System.out.println("定位元素异常");
//                        }
//                        return element;
//                    }
//                });
        return webElement;
    }


    public void getElementToClick(By byFor,int second) throws Exception {
       //byfor = By.id("")
        if(second!=0){
            WebElement element = LocationElement(byFor, second);
            if (element != null) {
                try{
                    log.info("获取到元素:"+element.getText());
                }catch(Exception e){
                    log.info("获取到元素:"+element.getLocation());
                }

            } else {
                throw new Exception("找不到元素");
            }
            element.click();
        }else{
            driver.findElement(byFor).click();
        }
    }

    public void getElementToSubmit(By byFor,int second) throws Exception {
        //byfor = By.id("")
        if(second!=0){
            WebElement element = LocationElement(byFor, second);
            if (element != null) {
                try{
                    log.info("获取到元素:"+element.getText());
                }catch(Exception e){
                    log.info("获取到元素:"+element.getLocation());
                }

            } else {
                throw new Exception("找不到元素");
            }
            element.submit();
        }else{
            driver.findElement(byFor).submit();
        }
    }
    public void getElementToClear(By byFor,int second) throws Exception {
        //byfor = By.id("")
        if(second!=0){
            WebElement element = LocationElement(byFor, second);
            if (element != null) {
                try{
                    log.info("获取到元素:"+element.getText());
                }catch(Exception e){
                    log.info("获取到元素:"+element.getLocation());
                }

            } else {
                throw new Exception("找不到元素");
            }
            element.clear();
        }else{
            driver.findElement(byFor).clear();
        }
    }

    public void getElementToSendKeys(By byFor,String context,int second) throws Exception {
        //byfor = By.id("")
        if(second!=0){
            WebElement element = LocationElement(byFor, second);
            if (element != null) {
                try{
                    log.info("获取到元素:"+element.getText());
                }catch(Exception e){
                    log.info("获取到元素:"+element.getLocation());
                }

            } else {
                throw new Exception("找不到元素");
            }
            element.sendKeys(context);
        }else{
            driver.findElement(byFor).sendKeys(context);
        }
    }
    public String getElementText(By byFor,int second) throws Exception {
        if (second != 0) {
            WebElement element = LocationElement(byFor, second);
            if (element != null) {
                try {
                    log.info("获取到元素:" + element.getText());
                } catch (Exception e) {
                    log.info("获取到元素:" + element.getLocation());
                }

            } else {
                throw new Exception("找不到元素");
            }
            return element.getText();
        } else {
            return driver.findElement(byFor).getText();
        }
    }




//    public static void main(String[] args) throws Exception {
//        AppiumDriver driver = null;
//        DriverHolder app = new DriverHolder("127.0.0.1",4723);
//        app.initDriver("Android","35c5817f","10","com.wuba","com.wuba.activity.launch.LaunchActivity","","");
//        Thread.sleep(5000);
////        app.getElementToClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.RelativeLayout\n"), 5);
//        app.getElementToClick(By.xpath("//*[@text='家政']"), 0);
//        app.getElementToClick(By.xpath("//*[@text='找保姆']"), 5);
//
//        Thread.sleep(10000);
//
//
//    }
////


    public AppiumDriver getDriver() {
        return driver;
    }
}