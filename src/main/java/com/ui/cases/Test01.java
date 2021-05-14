package com.ui.cases;

import com.ui.base.UiTestBase;
import org.testng.annotations.Test;

public class Test01 extends UiTestBase {
    @Test
    public void testM() throws Exception {
         throw  new Exception();
    }
    @Test
    public void testR() throws Exception {
        assert 1==1;
    }
}
