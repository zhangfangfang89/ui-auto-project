package com.ui.cases;

import com.ui.base.UiTestBase;
import com.ui.pages.BHome;

import org.testng.annotations.Test;



public class Test01 extends UiTestBase {



    @Test
    public void testM() throws Exception {

         BHome bHome = new BHome(super.driverHolder);
         bHome.clickMyBotton();
         assert 1==1;
    }
    @Test
    public void testR() throws Exception {
        BHome bHome = new BHome(super.driverHolder);
        assert 1==1;
    }
}
