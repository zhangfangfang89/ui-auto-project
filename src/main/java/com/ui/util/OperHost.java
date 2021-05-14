package com.ui.util;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
/**
 * <pre>
 *      业务描述：暴力覆盖写入本地host，后期可根据业务需要优化
 * </pre>
 *
 * @author zhangfangfang
 * @since 2021/5/10
 */

public class OperHost {
    private String dir;
    public static Logger log = Logger.getLogger(OperHost.class);

    public OperHost(String dir) throws IOException {
        if(dir.equals("")){
            throw new IOException("未指定本地的host路径");
        }
        this.dir = dir;
    }

    public void reWrite(HashMap<String, String> hosts) throws Exception {
         AtomicReference<String> writeHosts = new AtomicReference<>("");
         PrintStream printStream = new PrintStream(this.dir);
         if(hosts instanceof HashMap){
             Set<String> keys = hosts.keySet();
             keys.forEach((e)-> {
                 writeHosts.set(writeHosts + String.format("%s\t%s%n", e, hosts.get(e)));
             });


             printStream.print(writeHosts);
             log.info("覆盖写入本地host");



         }else{
             throw new IOException("实参传入有误，请传入map类型的数据");
         }


        //读取文件
        //覆盖写入
        //log

    }

    public static void main(String[] args) throws Exception {
        HashMap<String,String> hostMap = new HashMap<>();
        ReadProperties readProperties = new ReadProperties();
        readProperties.getProperties("base.properties","jiazheng.58.com");
        readProperties.getProperties("base.properties","jiafu.58.com");
        readProperties.getProperties("base.properties","j1.58cdn.com.cn");
        readProperties.getProperties("base.properties","c.58cdn.com.cn");
        HashMap<String,String> hosts = readProperties.propertyMap;
        System.out.println(hosts);
        OperHost p = new OperHost("");
        p.reWrite(hosts);

    }
}
