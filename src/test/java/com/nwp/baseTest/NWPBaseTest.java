package com.nwp.baseTest;

import com.nwp.page.utils.ProjectUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class NWPBaseTest {

    public WebDriver driver;

    public void setup() {
	driver = new ChromeDriver();
	String baseURL = ProjectUtilities.properties.getProperty("baseURL");
    driver.manage().window().maximize();
	driver.get(baseURL);
	System.out.println("base url is " + baseURL);
    }

    @BeforeSuite
    public void beforeSuite() {
	ProjectUtilities.readProperties();
	setup();
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
}
