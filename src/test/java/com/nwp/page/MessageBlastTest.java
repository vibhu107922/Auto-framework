package com.nwp.page;

import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.dashboard.DashboardClass;
import com.nwp.page.login.LoginClass;
import com.nwp.page.messageblast.MessageBlastClass;
import com.nwp.utils.ProjectUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MessageBlastTest extends NWPBaseTest {
    LoginClass loginClass;
    DashboardClass dashboardClass;
    MessageBlastClass messageBlastClass;

    @BeforeClass
    private void setupLogin() {
	loginClass = new LoginClass(driver);
	dashboardClass = new DashboardClass(driver);
	messageBlastClass = new MessageBlastClass(driver);
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
    public void verifySendMessageBlastList() throws Exception {
	dashboardClass.navigateToMessageBlast();
	String emailMessageBody = ProjectUtilities.randomStringGenerator(100);
	String emailList = ProjectUtilities.randomStringGenerator(7)
		+ "@gmail.com";
	String emailSubject = ProjectUtilities.randomStringGenerator(20);

	messageBlastClass.selectEventToPromote();
	messageBlastClass.selectEmailGuestOfPastEvent();
	messageBlastClass.enterEmailList(emailList);
	messageBlastClass.enterEmailSubject(emailSubject);
	messageBlastClass.enterEmailMessage(emailMessageBody);

	messageBlastClass.sendEmail();
    }

    @AfterClass
    private void logoutUser() {
	dashboardClass.logoutUser();
	Assert.assertEquals(true, loginClass.waitForLogout());
    }
}
