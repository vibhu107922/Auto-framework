package com.nwp.page;

import com.nwp.basePage.NWPBasePage;
import com.nwp.baseTest.NWPBaseTest;
import com.nwp.page.dashboard.DashboardClass;
import com.nwp.page.login.LoginClass;
import com.nwp.page.promocode.PromocodeClass;
import com.nwp.utils.ProjectUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Calendar;

public class PromocodeTest extends NWPBaseTest {
    LoginClass loginClass;
    DashboardClass dashboardClass;
    PromocodeClass promocodeClass;
    NWPBasePage nwpBasePageClass;

    @BeforeClass
    private void setupLogin() {
	loginClass = new LoginClass(driver);
	dashboardClass = new DashboardClass(driver);
	promocodeClass = new PromocodeClass(driver);
	nwpBasePageClass = new NWPBasePage(driver);

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
    public void verifyAddPromocode() {
	String promocodeName = ProjectUtilities.randomStringGenerator(10);
	try {
	    dashboardClass.navigateToAddEditPromocode();
	    promocodeClass.selectEvent(0);
	    dashboardClass.waitForPageLoadToBeRemoved();
	    promocodeClass.selectTicket(0);
        dashboardClass.waitForPageLoadToBeRemoved();
	    promocodeClass.enterPromocodeName(promocodeName);
	    Calendar currentCalendar = Calendar.getInstance();
	    promocodeClass.enterValidFromDate(currentCalendar);
	    currentCalendar.add(Calendar.MONTH, 2);
	    promocodeClass.enterValidUptoDate(currentCalendar);
	    promocodeClass.enterDiscountAmount("100.67");
	    promocodeClass.enterAllowedUsageAmount("25");
	    promocodeClass.savePromoCode();

	    Assert.assertEquals(nwpBasePageClass.dialogBoxContainsSuccess(),
		    true,
		    "It seems that Success was not received when we added a new Promocode");

	    nwpBasePageClass.confirmDialogBox();

	} catch (Exception | AssertionError e) {
	    e.printStackTrace();
	    Assert.fail();
	}
    }

    @Test
    public void verifyEditPromocode(){
        String newPromocodeName = ProjectUtilities.randomStringGenerator(10);
        try {
            dashboardClass.navigateToAddEditPromocode();
            promocodeClass.navigateToEditPromocode();
            promocodeClass.selectEditEvent(0);
            dashboardClass.waitForPageLoadToBeRemoved();
            promocodeClass.selectEditTicket(1);
            dashboardClass.waitForPageLoadToBeRemoved();
            promocodeClass.editPromocodeName(newPromocodeName);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.add(Calendar.MONTH, 2);
            promocodeClass.enterEditValidUptoDate(currentCalendar);
            promocodeClass.updatePromoCode();

            Assert.assertEquals(nwpBasePageClass.dialogBoxContainsSuccess(),
                    true,
                    "It seems that Success was not received when we added a new Promocode");

            nwpBasePageClass.confirmDialogBox();
        }
        catch (Exception | AssertionError e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @AfterClass
    private void logoutUser() {
	dashboardClass.logoutUser();
	Assert.assertEquals(true, loginClass.waitForLogout());
    }
}
