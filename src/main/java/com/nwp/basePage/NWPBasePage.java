package com.nwp.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

public class NWPBasePage {

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

    public static <T> void setFluentWait(WebDriver driver,
	    Function<? super WebDriver, T> condition, int timeoutInSeconds) {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
	wait.until(condition);
    }

}
