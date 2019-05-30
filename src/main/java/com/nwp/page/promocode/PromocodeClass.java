package com.nwp.page.promocode;

import com.nwp.basePage.NWPBasePage;
import com.nwp.utils.ProjectUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;

public class PromocodeClass extends NWPBasePage implements PromocodeConstants {

    private WebDriver driver;

    public PromocodeClass(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

    @FindBy(css = editPromocodeButtonCss)
    WebElement editPromocodeButton;

    @FindBy(css = addPromocodeButtonCss)
    WebElement addPromocodeButton;

    @FindBy(css = eventSelectButtonCss)
    WebElement eventSelectButton;

    @FindBy(css = editEventSelectButtonCss)
    WebElement editEventSelectButton;

    @FindBy(css = ticketSelectButtonCss)
    WebElement ticketSelectButton;

    @FindBy(css = editTicketSelectButtonCss)
    WebElement editTicketSelectButton;

    @FindBy(css = promocodeTextCss)
    WebElement promocodeText;

    @FindBy(css = editPromocodeTextCss)
    WebElement editPromocodeText;

    @FindBy(css = validFromDateSelectCss)
    WebElement validFromDateSelect;

    @FindBy(css = validUptoDateSelectCss)
    WebElement validUptoDateSelect;

    @FindBy(css = editValidUptoDateSelectCss)
    WebElement editValidUptoDateSelect;

    @FindBy(css = discountAmountTextCss)
    WebElement discountAmountText;

    @FindBy(css = allowedUsageTextCss)
    WebElement allowedUsageText;

    @FindBy(css = savePromocodeButtonCss)
    WebElement savePromocodeButton;

    @FindBy(css = updatePromocodeButtonCss)
    WebElement updatePromocodeButton;

    public void navigateToAddPromocode() throws Exception {
        addPromocodeButton.click();
    }

    public void navigateToEditPromocode() throws Exception {
        editPromocodeButton.click();
    }

    public void savePromoCode(){
        savePromocodeButton.click();
    }

    public void updatePromoCode(){
        updatePromocodeButton.click();
    }

    public void selectEvent() throws Exception{
        Select selectEventDropdown = new Select(eventSelectButton);
        selectEventDropdown.selectByVisibleText("Published Event");
        Thread.sleep(1000);
    }

    public void selectEditEvent(int indexNumber) throws Exception{
        Select selectEventDropdown = new Select(editEventSelectButton);
        selectEventDropdown.selectByIndex(indexNumber);
        Thread.sleep(1000);
    }

    public void selectTicket(int indexNumber){
        Select selectTicketDropdown = new Select(ticketSelectButton);
        selectTicketDropdown.selectByIndex(indexNumber);
    }

    public void selectEditTicket(int indexNumber){
        Select selectTicketDropdown = new Select(editTicketSelectButton);
        selectTicketDropdown.selectByIndex(indexNumber);
    }

    public void enterPromocodeName(String promocodeName){
        promocodeText.clear();
        promocodeText.sendKeys(promocodeName);
    }

    public void editPromocodeName(String promocodeName){
        editPromocodeText.clear();
        editPromocodeText.sendKeys(promocodeName);
    }

    public void enterValidFromDate(Calendar calendar) throws Exception{
        validFromDateSelect.click();
        Thread.sleep(1000);
        dateTimeSelector(calendar);
        Thread.sleep(1000);
        clickSetButton();
        Thread.sleep(1000);
    }

    public void enterValidUptoDate(Calendar calendar) throws Exception{
        validUptoDateSelect.click();
        dateTimeSelector(calendar);
        Thread.sleep(1000);
        clickSetButton();
        Thread.sleep(1000);
    }

    public void enterEditValidUptoDate(Calendar calendar) throws Exception{
        editValidUptoDateSelect.click();
        dateTimeSelector(calendar);
        Thread.sleep(1000);
        clickSetButton();
        Thread.sleep(1000);
    }

    public void enterDiscountAmount(String discountMoney) throws Exception{
        discountAmountText.click();
        enterMoneyInDialogBox(discountMoney,true);
        clickSetButton();
        Thread.sleep(1000);
    }

    public void enterAllowedUsageAmount(String allowedUsageMoney) throws Exception{
        ProjectUtilities.scrollToBottom(driver);
        allowedUsageText.click();
        enterMoneyInDialogBox(allowedUsageMoney,false);
        clickSetButton();
        Thread.sleep(1000);
    }
    
    public void clickOk() {
    	driver.findElement(By.xpath("//div[@class='mbsc-fr-btn-w mbsc-fr-btn-s']")).click();
    
    	
    }
    
    public void refreshPage() {
    	driver.navigate().refresh();
    }

    public void navigate(String url) {
    	driver.navigate().to(url);
    }


}
