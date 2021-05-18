package com.ui.pages;

import com.ui.util.DriverHolder;

import org.openqa.selenium.By;

public class BHome {
    private final DriverHolder driverHolder;
    public By B;

    public BHome(DriverHolder driverHolder) {
        this.driverHolder = driverHolder;
    }

    public void clickMyBotton() throws Exception {
        System.out.println("哈哈哈");
//        driverHolder.getElementToClick(B, 0);
    }
}
