package com.nwp.baseTest;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class NWPBaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
	NWPBasePage.readProperties();
    }
}
