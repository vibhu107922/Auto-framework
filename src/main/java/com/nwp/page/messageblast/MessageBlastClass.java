package com.nwp.page.messageblast;

import com.nwp.basePage.NWPBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageBlastClass extends NWPBasePage
	implements MessageBlastConstants {
    private WebDriver driver;

    public MessageBlastClass(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

    @FindBy(css = eventToPromoteCss)
    WebElement eventToPromoteSelect;

    @FindBy(css = emailGuestListPastEventCss)
    WebElement emailGuestListPastEventSelect;

    @FindBy(css = firstElementCss)
    WebElement firstOption;

    @FindBy(css = messageBlastReceiverEmailListCss)
    WebElement messageBlastReceiverEmailListTextArea;

    @FindBy(css = emailSubjectCss)
    WebElement emailSubjectText;

    @FindBy(id = messageBodyIFrameId)
    WebElement messageBodyIFrame;

    @FindBy(css = messageBodyCss)
    WebElement messageBodyTextArea;

    @FindBy(css = sendEmailCss)
    WebElement sendEmailButton;

    @FindBy(css = setCss)
    WebElement setButton;

    public void selectEventToPromote() throws Exception{
        eventToPromoteSelect.click();
        Thread.sleep(1000);

        setButton.click();
        Thread.sleep(1000);
    }

    public void enterEmailSubject(String subject){
        emailSubjectText.sendKeys(subject);
    }

    public void enterEmailMessage(String message) throws Exception{
        driver.switchTo().frame(messageBodyIFrame);
        Thread.sleep(1000);
        messageBodyTextArea.sendKeys(message);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }

    public void enterEmailList(String emailList){
        messageBlastReceiverEmailListTextArea.sendKeys(emailList);
    }

    public void selectEmailGuestOfPastEvent() throws Exception{
        emailGuestListPastEventSelect.click();
        Thread.sleep(1000);
        firstOption.click();
        setButton.click();
        Thread.sleep(1000);
    }

    public void sendEmail(){
        sendEmailButton.click();
    }

}
