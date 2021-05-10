package com.ui.util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;

/**
 * <pre>
 *      业务描述：
 * </pre>
 *
 * @author mac
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
    private Boolean ensureWebviewsHavePages;
    private HttpCommandExecutor appiumServerUrl;

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


    public HttpCommandExecutor getAppiumServerUrl() {
        return appiumServerUrl;
    }

    public void setAppiumServerUrl(HttpCommandExecutor appiumServerUrl) {
        //appiumServerUrl=new URL();
        this.appiumServerUrl = appiumServerUrl;
    }

    //获取driver
    public AndroidDriver getDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", getPlatformName());
        desiredCapabilities.setCapability("appPackage", getAppPackage());
        desiredCapabilities.setCapability("deviceName", getDeviceName());
        desiredCapabilities.setCapability("platformVersion", getPlatformVersion());
        desiredCapabilities.setCapability("appActivity", getAppActivity());
        desiredCapabilities.setCapability("resetKeyboard", getResetKeyboard());
        desiredCapabilities.setCapability("noReset", getNoReset());
        desiredCapabilities.setCapability("automationName", getAutomationName());
        desiredCapabilities.setCapability("ensureWebviewsHavePages", getEnsureWebviewsHavePages());
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, desiredCapabilities);
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


}