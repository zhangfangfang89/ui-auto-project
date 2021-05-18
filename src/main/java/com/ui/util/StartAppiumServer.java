package com.ui.util;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.*;


/**
 * <pre>
 *      业务描述：用于启动appiumserver ，需要指定host port
 * </pre>
 *
 * @author zhangfangfang
 * @since 2021/5/9 17:04
 */
public class StartAppiumServer {
    private AppiumDriverLocalService appiumDriverLocalService;
    private  AppiumServiceBuilder appiumServiceBuilder;
    private  int port;
    private  String host;
    public static Logger log = Logger.getLogger(StartAppiumServer.class);

    public StartAppiumServer(int port, String host) {
        this.port = port;
        this.host = host;
    }
    //判断要开启appiumserver 的端口是否已经被占用了
    public Boolean isRunPort() throws UnknownHostException {
        boolean isPortRunning = false;
        InetAddress address = InetAddress.getByName(host);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            SocketAddress endpoint = new InetSocketAddress(address, this.port);
            serverSocket.bind(endpoint);
        } catch (IOException e) {
            log.error(this.port + "端口已经被占用", e);
            isPortRunning = true;
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {

                }
            }
        }
        return isPortRunning;
    }




    //开启指定的appium的server，用于每次运行前执行
    public AppiumDriverLocalService startServer() throws Exception {
        Boolean portIfRunning = isRunPort();
        if (portIfRunning) {
            throw new RuntimeException("该端口" + this.port + "被占用了，请换一个端口号！！");
        } else {
            appiumServiceBuilder = new AppiumServiceBuilder()
                    .withIPAddress(this.host)
                    .usingPort(this.port);

            appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
            appiumDriverLocalService.start();
            return appiumDriverLocalService;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        try {
            new StartAppiumServer(8081, "127.0.0.1").startServer();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Thread.sleep(3000);
    }
}
