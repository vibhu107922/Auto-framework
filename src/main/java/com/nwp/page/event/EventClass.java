package com.nwp.page.event;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;

public class EventClass extends NWPBasePage implements EventConstants {

    private WebDriver driver;

    @FindBy(xpath=createEventXpath)
    WebElement createEvent;

    @FindBy(xpath = createEventFormCss)
    WebElement createEventForm;

    @FindBy(id=eventTitleNameId)
    WebElement eventTitleName;

    @FindBy(xpath=eventStartDateCss)
    WebElement eventStartDate;

    @FindBy(css=eventCalenderSetButtonCss)
    WebElement eventCalenderSetButton;

    @FindBy(xpath=eventEndDateCss)
    WebElement eventEndDate;

    public EventClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnCreateEvent(){
        createEvent.click();
        setFluentWait(driver, ExpectedConditions.visibilityOf(createEventForm),10000);
    }

    public void addEventName(String eventName){
        eventTitleName.sendKeys(eventName);
    }

    public void setEventStartDate(){
        eventStartDate.click();
        driver.switchTo().frame(eventIframeId);
        eventCalenderSetButton.click();
        driver.switchTo().defaultContent();
    }

    public void setEventEndDate(){
        eventEndDate.click();
        Date date= new Date();
        int currentDate = date.getDate();
        driver.switchTo().frame(eventIframeId);
        WebElement nextDayOnCalendar = driver.findElement(By.xpath(String.format(eventNextDate,currentDate)));
        nextDayOnCalendar.click();
        eventCalenderSetButton.click();
        driver.switchTo().defaultContent();
    }

}
