package com.nwp.page.login;

import com.nwp.basePage.NWPBasePage;
import com.nwp.utils.ProjectUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginClass extends NWPBasePage implements LoginConstants {
    private WebDriver driver;

    @FindBy(css = userNameTextCss)
    WebElement userNameText;

    @FindBy(css = passwordTextCss)
    WebElement passwordText;

    @FindBy(css = loginButtonCss)
    WebElement loginButton;

    @FindBy(css = pageLoaderCss)
    WebElement pageLoader;

    public LoginClass(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

    public void loginUser(String userName, String password) {
	ProjectUtilities.waitForElementAttributeToChange(driver, pageLoader,
		"style", "display: none;");
	userNameText.sendKeys(userName);
	passwordText.sendKeys(password);
	loginButton.click();
    }

    public boolean waitForLogout(){
        setFluentWait(driver, ExpectedConditions.visibilityOf(loginButton),standardTimeOut);
        return true;
    }
}
