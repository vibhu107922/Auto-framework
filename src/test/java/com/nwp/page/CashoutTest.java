package com.nwp.page;

import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.dashboard.DashboardClass;
import com.nwp.page.login.LoginClass;
import com.nwp.utils.ProjectUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CashoutTest extends NWPBaseTest {
    LoginClass loginClass;
    DashboardClass dashboardClass;

    @BeforeClass
    private void setupLogin() {
	loginClass = new LoginClass(driver);
	dashboardClass = new DashboardClass(driver);
        String userName = ProjectUtilities.properties.getProperty("userName");
        String password = ProjectUtilities.properties.getProperty("password");
        try {
            loginClass.loginUser(userName, password);
            Assert.assertEquals(true, dashboardClass.waitForLogin());
        } catch (Exception | AssertionError e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void verifyCashoutFeature() throws Exception{
        dashboardClass.navigateToCashout();
    }

    @AfterClass
    private void logoutUser(){
        dashboardClass.logoutUser();
        Assert.assertEquals(true,loginClass.waitForLogout());
    }
}
