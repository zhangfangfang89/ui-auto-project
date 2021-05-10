package com.ui.util;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;


/**
 * <pre>
 *      业务描述：
 * </pre>
 *
 * @author mac
 * @since 2021/5/9 17:04
 */
public class StarAppiumServer {
    private AppiumDriverLocalService appiumDriverLocalService;
    private AppiumServiceBuilder appiumServiceBuilder;
    private int port;
    private String host;
    public static Logger log = Logger.getLogger(StarAppiumServer.class);

    public StarAppiumServer(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public Boolean isRunPort() {
        boolean isPortRunning = false;

        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(this.port);

            serverSocket.close();

        } catch (IOException e) {
//If control comes here, then it means that the port is in use

            isPortRunning = true;

        } finally {
            serverSocket = null;

        }

        return isPortRunning;

    }


    public void starAppiumServer() throws Exception {

        Boolean portIfRunning = isRunPort();
        if (portIfRunning) {
            log.error("该端口" + this.port + "被占用了，请换一个端口号！！");
            throw new RuntimeException("该端口" + this.port + "被占用了，请换一个端口号！！");

        } else {

            appiumServiceBuilder = new AppiumServiceBuilder()
                    .withIPAddress(this.host)
                    .usingPort(this.port);

            appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
            appiumDriverLocalService.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            new StarAppiumServer(8080, "127.0.0.1").starAppiumServer();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        new Thread().sleep(30);
    }
}
