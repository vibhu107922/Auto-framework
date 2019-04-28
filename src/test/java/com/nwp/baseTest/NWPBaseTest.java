package com.nwp.baseTest;

import com.nwp.basePage.NWPBasePage;
import org.testng.annotations.BeforeSuite;

public class NWPBaseTest {
    @BeforeSuite
    public void beforeSuite(){
        NWPBasePage.readProperties();
    }
}
