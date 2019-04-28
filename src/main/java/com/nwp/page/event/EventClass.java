package com.nwp.page.event;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventClass extends NWPBasePage implements EventConstants {

    private WebDriver driver;

    @FindBy(xpath=createEventXpath)
    WebElement createEvent;

    @FindBy(xpath = createEventFormXpath)
    WebElement createEventForm;

    @FindBy(id=eventTitleNameId)
    WebElement eventTitleName;

    public EventClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnCreateEvent(){
        createEvent.click();
        //wait for createEventform
    }

    public void addEventName(){
        eventTitleName.sendKeys();
    }

}
