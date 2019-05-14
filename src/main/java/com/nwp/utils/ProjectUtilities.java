package com.nwp.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectUtilities {
    public static Properties properties;

    public static void readProperties() {
	if (properties == null) {
	    properties = new Properties();
	    try {
		properties.load(new FileInputStream(
			new File(".//src//main//resources//nwp.properties")));
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

    public static void waitForElementAttributeToChange(WebDriver driver,
	    WebElement element, String attributeName,
	    String finalAttributeValue) {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(new ExpectedCondition<Boolean>() {
	    public Boolean apply(WebDriver driver) {
		String enabled = element.getAttribute(attributeName);
		return enabled.equals(finalAttributeValue);
	    }
	});
    }
}
