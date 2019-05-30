package com.nwp.page.addGuest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nwp.basePage.NWPBasePage;
import com.nwp.page.addGuest.AddGuestConstants;

public class AddGuestClass extends NWPBasePage implements AddGuestConstants {
	
	  private WebDriver driver;
	  
	  @FindBy(css=addGuestCSS)
	    WebElement addGuestTab;
    
	  @FindBy(css=addGuestTabCSS)
	    WebElement addGuestButton;

	  
	  
	
	  
	  public AddGuestClass(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    }

	    public  void clickOnAddGuest() throws Exception{
	        Thread.sleep(5000);
	        addGuestTab.click();
	        Thread.sleep(2000);
	    }
	  
	
}
