package com.nwp.page.dashboard;

import com.nwp.basePage.NWPBasePage;
import com.nwp.utils.ProjectUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.nwp.utils.ProjectUtilities;
import java.util.List;

public class DashboardClass extends NWPBasePage implements DashboardConstants {

    private WebDriver driver;
    public DashboardClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=profileCss)
    WebElement profileButton;

    @FindBy(css=settingsCss)
    WebElement settingsButton;

    @FindBy(css=logoutCss)
    WebElement logoutButton;

    @FindBy(css=cashoutCss)
    WebElement cashoutButton;

    @FindBy(css=addPromoterCss)
    WebElement addPromoterButton;

    @FindBy(css=messageBlastCss)
    WebElement messageBlastButton;

    @FindBy(css=addEditPromocodeCss)
    WebElement addEditPromocode;

    @FindBy(css=dashboardCss)
    WebElement dashboard;

    @FindBy(css = pageLoaderCss)
    WebElement pageLoader;

    public boolean waitForLogin() throws Exception {
        Thread.sleep(1000);
        waitForPageLoadToBeRemoved();
        setFluentWait(driver, ExpectedConditions.visibilityOf(profileButton),standardTimeOut);
        return true;
    }

    public void logoutUser(){
        waitForPageLoadToBeRemoved();
        setFluentWait(driver,ExpectedConditions.elementToBeClickable(settingsButton),standardTimeOut);
        settingsButton.click();
        logoutButton.click();
    }

    public void clickDashboard() throws Exception{
        Thread.sleep(1000);
        dashboard.click();
    }

    public boolean newCreatedEventFoundInList(String eventName) throws Exception {
        Thread.sleep(3000);
        List<WebElement> listOfEvents = driver.findElements(By.cssSelector(eventDropdownCss));
        boolean eventFound = false;
        for (WebElement event : listOfEvents) {
            if (event.getText().contains(eventName))
                eventFound = true;
        }
        return eventFound;
    }

    public void navigateToCashout() throws Exception{
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cashoutButton);
        setFluentWait(driver,ExpectedConditions.visibilityOf(cashoutButton),standardTimeOut);
        cashoutButton.click();
        Thread.sleep(1000);
        waitForPageLoadToBeRemoved();
    }

    public void waitForPageLoadToBeRemoved(){
        ProjectUtilities.waitForElementAttributeToChange(driver,pageLoader,"style","display: none;");
    }

    public void navigateToAddPromoter() throws Exception{
        setFluentWait(driver,ExpectedConditions.visibilityOf(addPromoterButton),standardTimeOut);
        addPromoterButton.click();
        Thread.sleep(1000);
        waitForPageLoadToBeRemoved();
    }

    public void navigateToMessageBlast() throws Exception{
        setFluentWait(driver,ExpectedConditions.visibilityOf(messageBlastButton),standardTimeOut);
        messageBlastButton.click();
        Thread.sleep(1000);
        waitForPageLoadToBeRemoved();
    }

    public void navigateToAddEditPromocode() throws Exception{
        setFluentWait(driver,ExpectedConditions.visibilityOf(addEditPromocode),standardTimeOut);
        addEditPromocode.click();
        Thread.sleep(1000);
        waitForPageLoadToBeRemoved();
    }

}
