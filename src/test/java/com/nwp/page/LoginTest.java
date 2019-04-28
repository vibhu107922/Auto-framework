package com.nwp.page;

import com.nwp.basePage.NWPBasePage;
import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.dashboard.DashboardClass;
import com.nwp.page.login.LoginClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends NWPBaseTest {
    LoginClass loginClass;
    DashboardClass dashboardClass;

    @BeforeClass
    private void classInit() {
        loginClass = new LoginClass(driver);
        dashboardClass = new DashboardClass(driver);
    }

    @Test
    public void loginTest() {
        String userName = NWPBasePage.properties.getProperty("userName");
        String password = NWPBasePage.properties.getProperty("password");
        try {
            loginClass.loginUser(userName, password);
            Assert.assertEquals(true, dashboardClass.waitForLogin());
        } catch (Exception | AssertionError e) {
            Assert.fail();
        }
    }
}
