package com.nwp.page.dashboard;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(css=dashboardCss)
    WebElement dashboard;

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

    public void clickDashboard() throws Exception{
        Thread.sleep(1000);
        dashboard.click();
    }

    public boolean newCreatedEventFoundInList(String eventName) throws Exception{
        Thread.sleep(3000);
        List<WebElement> listOfEvents = driver.findElements(By.cssSelector(eventDropdownCss));
        boolean eventFound =false;
        for(WebElement event : listOfEvents){
            if(event.getText().contains(eventName))
                eventFound=true;
        }
        return eventFound;
    }
}
