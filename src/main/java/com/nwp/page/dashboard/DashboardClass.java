package com.nwp.page.dashboard;

import com.nwp.basePage.NWPBasePage;
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

    public boolean waitForLogin() {
        setFluentWait(driver, ExpectedConditions.visibilityOf(profileButton),30);
        return true;
    }
}
