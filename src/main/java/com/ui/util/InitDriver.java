package com.ui.util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 *      业务描述：启动一个appdriver
 * </pre>
 *
 * @author zhangfangfang
 * @since 2021/5/9 16:45
 */
public class InitDriver {
    private String platformName;
    private String appPackage;
    private String deviceName;
    private String platformVersion;
    private String appActivity;
    private Boolean resetKeyboard;
    private Boolean noReset;
    private String automationName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        this.url = url + "/wd/hub";
        System.out.println(this.url);
    }

    private Boolean ensureWebviewsHavePages;
    private String url;

    public Boolean getNoReset() {
        return noReset;
    }

    public void setNoReset(Boolean noReset) {
        this.noReset = noReset;
    }

    public Boolean getEnsureWebviewsHavePages() {
        return ensureWebviewsHavePages;
    }

    public void setEnsureWebviewsHavePages(Boolean ensureWebviewsHavePages) {
        this.ensureWebviewsHavePages = ensureWebviewsHavePages;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public Boolean getResetKeyboard() {
        return resetKeyboard;
    }

    public void setResetKeyboard(Boolean resetKeyboard) {
        this.resetKeyboard = resetKeyboard;
    }

    public String getAutomationName() {
        return automationName;
    }

    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }


    //获取driver
    public Object getDriver() throws MalformedURLException {
        //读书配置文件进行赋值
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", getPlatformName());
        desiredCapabilities.setCapability("appPackage", getAppPackage());
        desiredCapabilities.setCapability("deviceName", getDeviceName());
        desiredCapabilities.setCapability("platformVersion", getPlatformVersion());
        desiredCapabilities.setCapability("appActivity", getAppActivity());
        desiredCapabilities.setCapability("resetKeyboard", getResetKeyboard());
        desiredCapabilities.setCapability("noReset", getNoReset());
        //desiredCapabilities.setCapability("automationName", getAutomationName());
        desiredCapabilities.setCapability("ensureWebviewsHavePages", getEnsureWebviewsHavePages());
        desiredCapabilities.setCapability("automationName", "Uiautomator2");
        AppiumDriver driver = new AppiumDriver(new URL(getUrl()), desiredCapabilities);
        return driver;
    }
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
//        desiredCapabilities.setCapability("deviceName", "V1838A");
//        desiredCapabilities.setCapability("platformVersion", "10");
//        desiredCapabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
//        desiredCapabilities.setCapability("resetKeyboard", true);
//        desiredCapabilities.setCapability("noReset", true);
//        desiredCapabilities.setCapability("automationName", "UiAutomator2");
//        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = null;
        InitDriver app = new InitDriver();
        app.setPlatformName("Android");
        app.setDeviceName("35c5817f");
        app.setPlatformVersion("10");
        app.setAppPackage("com.android.calendar");
        app.setAppActivity("com.android.calendar.homepage.AllInOneActivity");
        app.setResetKeyboard(true);
        app.setNoReset(true);
        app.setEnsureWebviewsHavePages(true);
        app.setUrl("http://127.0.0.1:4723");
        driver = (AppiumDriver) app.getDriver();

        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}