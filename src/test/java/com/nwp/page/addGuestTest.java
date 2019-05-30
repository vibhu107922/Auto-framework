package com.nwp.page;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.addGuest.AddGuestClass;
import com.nwp.page.dashboard.DashboardClass;
import com.nwp.page.event.EventClass;
import com.nwp.page.login.LoginClass;
import com.nwp.utils.ProjectUtilities;

public class addGuestTest  extends NWPBaseTest {
	AddGuestClass addGuest;
    LoginClass loginClass;
    DashboardClass dashboardClass;

    @BeforeClass
    private void setupLogin() {
    	addGuest = new AddGuestClass(driver);
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
    
    
  //  @Test
    public void addGuest(){
        try {
        	addGuest.clickOnAddGuest();
           
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }


}
