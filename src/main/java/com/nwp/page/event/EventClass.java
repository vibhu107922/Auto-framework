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

    @FindBy(css=createEventCss)
    WebElement createEvent;

    @FindBy(css = createEventFormCss)
    WebElement createEventForm;

    @FindBy(css=eventTitleNameCss)
    WebElement eventTitleName;

    @FindBy(css=eventStartDateCss)
    WebElement eventStartDate;

    @FindBy(css=eventCalenderSetButtonCss)
    WebElement eventCalenderSetButton;

    @FindBy(css=eventEndDateCss)
    WebElement eventEndDate;

    @FindBy(css=venueCss)
    WebElement venue;

    @FindBy(css=emailCss)
    WebElement email;

    @FindBy(css=deleteTicketCss)
    WebElement deleteTicket;

    @FindBy(xpath=eventNextDateXpath)
    WebElement eventNextDate;

    @FindBy(css=nextButtonCss)
    WebElement nextButton;

    public EventClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void clickOnCreateEvent() throws Exception{
        Thread.sleep(5000);
        createEvent.click();
        Thread.sleep(2000);
    }

    public void addEventName(String eventName) throws Exception{
        Thread.sleep(1000);
        eventTitleName.sendKeys(eventName);
    }

    public void setEventStartDate()throws Exception{
        Thread.sleep(1000);
        eventStartDate.click();
        eventCalenderSetButton.click();
    }

    public void setEventEndDate()throws Exception{
        Thread.sleep(1000);
        eventEndDate.click();
        eventNextDate.click();
        eventCalenderSetButton.click();
    }

    public void setVenue(String venue){
        this.venue.sendKeys(venue);
    }

    public void setEmail(String email){
        this.email.sendKeys(email);
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public boolean verifyTicketCreated(){
        try{
            setFluentWait(driver,ExpectedConditions.visibilityOf(deleteTicket),10);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
