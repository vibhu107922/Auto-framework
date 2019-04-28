package com.nwp.page.login;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass extends NWPBasePage implements LoginConstants {
    private WebDriver driver;

    @FindBy(css=userNameTextCss)
    WebElement userNameText;

    @FindBy(css=passwordTextCss)
    WebElement passwordText;

    @FindBy(css=loginButtonCss)
    WebElement loginButton;

    public LoginClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginUser(String userName, String password){
        userNameText.sendKeys(userName);
        passwordText.sendKeys(password);
        loginButton.click();
    }
}
