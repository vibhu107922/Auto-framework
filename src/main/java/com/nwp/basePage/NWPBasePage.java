package com.nwp.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

public class NWPBasePage implements BasePageCommonConstants {

	private WebDriver driver;

    public static <T> void setFluentWait(WebDriver driver,
	    Function<? super WebDriver, T> condition, int timeoutInSeconds) {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(timeoutInSeconds))
		.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
	wait.until(condition);
    }

	public NWPBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public NWPBasePage(){

	}

	@FindBy(css = dialogBoxCss)
	WebElement dialogBox;

	@FindBy(css = confirmDiaglogBoxCss)
	WebElement confirmDialogBox;

    public static int standardTimeOut = 30;

    public boolean dialogBoxContainsSuccess(){
    	setFluentWait(driver, ExpectedConditions.elementToBeClickable(confirmDialogBox),standardTimeOut);
		return dialogBox.getText().toLowerCase().contains("success");
	}

	public void confirmDialogBox(){
		setFluentWait(driver, ExpectedConditions.elementToBeClickable(confirmDialogBox),standardTimeOut);
    	confirmDialogBox.click();
	}

}
