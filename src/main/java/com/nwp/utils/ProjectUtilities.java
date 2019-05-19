package com.nwp.utils;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.function.Function;

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

    public static String randomStringGenerator(int length) {
	char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	StringBuilder sb = new StringBuilder(length);
	Random random = new Random();
	for (int i = 0; i < length; i++) {
	    char c = chars[random.nextInt(chars.length)];
	    sb.append(c);
	}
	return sb.toString();
    }

    public static long randomNumberGenerator(int length) {
	return Math.round(Math.random() * Math.pow(10, length));
    }

	public static void scrollElementIntoView(WebDriver driver, WebElement element) throws Exception {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", new Object[]{element});
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-100)", new Object[0]);
		Thread.sleep(500);
	}

	public static void scrollToBottom(WebDriver driver){
		((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static boolean isElementClickable(WebDriver driver, WebElement element){
		try{
			NWPBasePage.setFluentWait(driver, ExpectedConditions.elementToBeClickable(element),NWPBasePage.standardTimeOut);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	public static void clickMatchingAttributeElement(WebDriver driver, List<WebElement> listOfWebElements, String attributeToBeMatched,
											  String valueToBeMatched){
		WebElement element = searchElementInList(listOfWebElements,attributeToBeMatched,valueToBeMatched);
		try {
			element.click();
		}
		catch (Exception e){
			System.out.println("Do nothing here and move ahead");
		}
	}

	public static WebElement searchElementInList(List<WebElement> elements, String attributeToBeMatched, String matchingValue){
    	for(WebElement element:elements){
    		if(element.getAttribute(attributeToBeMatched).equalsIgnoreCase(matchingValue))
    			return element;
		}
		return null;
	}

	public static String removeCharFromString(String testString, char charToBeRemoved){
		int index = testString.indexOf(charToBeRemoved);
		return testString.substring(0,index)+testString.substring(index+1);
	}

	public static List<WebElement> filterListOfWebElements(List<WebElement> originalList, String attributeToBeMatched, int minimumExpectedValue){
		List<WebElement> filteredList = new ArrayList<>();
    	for(WebElement element:originalList){
			if(Integer.parseInt(element.getAttribute(attributeToBeMatched))>=minimumExpectedValue)
				filteredList.add(element);
		}
		return filteredList;
	}
}
