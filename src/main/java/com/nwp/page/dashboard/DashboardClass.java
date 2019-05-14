package com.nwp.page.dashboard;

import com.nwp.basePage.NWPBasePage;
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

    public boolean waitForLogin() {
        setFluentWait(driver, ExpectedConditions.visibilityOf(profileButton),standardTimeOut);
        return true;
    }

    public void logoutUser(){
        setFluentWait(driver,ExpectedConditions.elementToBeClickable(logoutButton),standardTimeOut);
        settingsButton.click();
        logoutButton.click();
    }

    public void navigateToCashout(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cashoutButton);
        setFluentWait(driver,ExpectedConditions.visibilityOf(cashoutButton),standardTimeOut);
        cashoutButton.click();
    }
}
