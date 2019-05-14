package com.nwp.page.promoter;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromoterClass extends NWPBasePage implements PromoterConstants {
    private WebDriver driver;

    public PromoterClass(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

    @FindBy(css = userNameCss)
    WebElement userName;

    @FindBy(css = emailCss)
    WebElement email;

    @FindBy(css = mobileNumberCss)
    WebElement mobileNumber;

    @FindBy(css = roleDropDownCss)
    WebElement roleDropDown;

    @FindBy(css = parentCss)
    WebElement parent;

    @FindBy(css = digit1Css)
    WebElement digit1;

    @FindBy(css = setCss)
    WebElement setButton;

    @FindBy(css = firstElementCss)
    WebElement firstOption;

    @FindBy(css = saveCss)
    WebElement saveButton;

    public void enterUserNameEmailMobile(String name, String userEmail)
	    throws Exception {
	userName.sendKeys(name);
	Thread.sleep(1000);
	email.sendKeys(userEmail);
	Thread.sleep(1000);

	mobileNumber.click();

	for (int i = 0; i < 10; i++) {
	    digit1.click();
	}
	Thread.sleep(1000);

	setButton.click();
	Thread.sleep(1000);
    }

    public void selectRoleAndParent() throws Exception{
        roleDropDown.click();
        firstOption.click();
        setButton.click();
        Thread.sleep(1000);

        parent.click();
        firstOption.click();
        setButton.click();
        Thread.sleep(1000);
    }

    public void clickSaveButton() throws Exception{
        saveButton.click();
        Thread.sleep(3000);
    }
}
