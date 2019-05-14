package com.nwp.page;

import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.dashboard.DashboardClass;
import com.nwp.page.event.EventClass;
import com.nwp.page.login.LoginClass;
import com.nwp.utils.ProjectUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventTest extends NWPBaseTest {
    EventClass eventClass;
    LoginClass loginClass;
    DashboardClass dashboardClass;

    @BeforeClass
    private void setupLogin() {
        eventClass = new EventClass(driver);
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
    public void createEvent(){
        try {
            eventClass.clickOnCreateEvent();
            eventClass.addEventName("abc");
            eventClass.setEventStartDate();
            eventClass.setEventEndDate();
            eventClass.setVenue("zxcvb");
            eventClass.setEmail("abc@abc.com");
            eventClass.clickNextButton();
            boolean result = eventClass.verifyTicketCreated();
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }

    }

    @AfterClass
    private void logoutUser(){
        dashboardClass.logoutUser();
        Assert.assertEquals(true,loginClass.waitForLogout());
    }
}
