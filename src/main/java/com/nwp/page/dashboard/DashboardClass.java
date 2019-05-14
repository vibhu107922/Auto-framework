package com.nwp.page.dashboard;

import com.nwp.basePage.NWPBasePage;
import com.nwp.utils.ProjectUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
}
