package com.ui.run;

import org.testng.TestNG;

import java.util.ArrayList;

public class RunTestsThead extends Thread {
    public ArrayList<String> suites = new ArrayList<>();

    public void setSuites(String testXmlDir) {
        this.suites.add(testXmlDir);
    }

    @Override
    public void run() {
        TestNG testNG = new TestNG();
        testNG.setTestSuites(this.suites);
        testNG.run();
    }
}
