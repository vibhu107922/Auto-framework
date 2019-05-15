package com.nwp.page.ticket;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TicketClass extends NWPBasePage implements TicketConstants {

    private WebDriver driver;
    public TicketClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath=editButtonXpath)
    WebElement editButton;

    @FindBy(xpath=addTicketCss)
    WebElement addTicket;

    @FindBy(xpath=SuccessButtonOkCss)
    WebElement SuccessButtonOk;

    @FindBy(css=ticketNameCss)
    WebElement ticketName;

    @FindBy(css=ticketPriceCss)
    WebElement ticketPrice;

    @FindBy(css=priceDiv1Css)
    WebElement priceDiv1;

    @FindBy(css=SetButtonCss)
    WebElement SetButton;

    @FindBy(css=ticketQuantityCss)
    WebElement ticketQuantity;

    @FindBy(css=quantityDiv9Css)
    WebElement quantityDiv9;

    @FindBy(css=ticketSaveCss)
    WebElement ticketSave;



    public void clickOnEditButton() throws Exception{
        Thread.sleep(500);
        editButton.click();
    }

    public void addTicket()throws Exception{
        Thread.sleep(1000);
        setFluentWait(driver, ExpectedConditions.elementToBeClickable(addTicket),standardTimeOut);
        addTicket.click();
        SuccessButtonOk.click();
    }

    public void addTicketName(String ticketName){
        this.ticketName.sendKeys(ticketName);
    }

    public void addTicketPrice(){
        ticketPrice.click();
        for(int i=0;i<4;i++)
            priceDiv1.click();
        SetButton.click();
    }

    public void addTicketQuantity(){
        ticketQuantity.click();
        quantityDiv9.click();
        SetButton.click();

    }

    public void clickSaveTicket(){
        ticketSave.click();
        SuccessButtonOk.click();
    }
}
