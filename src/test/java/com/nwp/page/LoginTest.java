package com.nwp.page;

import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.dashboard.DashboardClass;
import com.nwp.page.login.LoginClass;
import com.nwp.page.utils.ProjectUtilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends NWPBaseTest {
    LoginClass loginClass;
    DashboardClass dashboardClass;

    @Test
    public void loginTest() {
	String userName = ProjectUtilities.properties.getProperty("userName");
	String password = ProjectUtilities.properties.getProperty("password");
	try {
	    loginClass.loginUser(userName, password);
	    Assert.assertEquals(true, dashboardClass.waitForLogin());
	} catch (Exception | AssertionError e) {
	    Assert.fail();
	}
    }

    @BeforeClass
    private void classInit() {
	loginClass = new LoginClass(driver);
	dashboardClass = new DashboardClass(driver);
    }
}
