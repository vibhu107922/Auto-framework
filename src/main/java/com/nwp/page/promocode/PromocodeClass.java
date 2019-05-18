package com.nwp.page.promocode;

import com.nwp.basePage.NWPBasePage;
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

    @FindBy(css = ticketSelectButtonCss)
    WebElement ticketSelectButton;

    @FindBy(css = promocodeTextCss)
    WebElement promocodeText;

    @FindBy(css = validFromDateSelectCss)
    WebElement validFromDateSelect;

    @FindBy(css = validUptoDateSelectCss)
    WebElement validUptoDateSelect;

    @FindBy(css = discountAmountTextCss)
    WebElement discountAmountText;

    @FindBy(css = allowedUsageTextCss)
    WebElement allowedUsageText;

    @FindBy(css = savePromocodeButtonCss)
    WebElement savePromocodeButton;

    public void navigateToAddPromocode() throws Exception {
        addPromocodeButton.click();
    }

    public void navigateToEditPromocode() throws Exception {
        editPromocodeButton.click();
    }

    public void savePromoCode(){
        savePromocodeButton.click();
    }

    public void selectEvent(int indexNumber) throws Exception{
        Select selectEventDropdown = new Select(eventSelectButton);
        selectEventDropdown.selectByIndex(indexNumber);
        Thread.sleep(1000);

    }

    public void selectTicket(int indexNumber){
        Select selectTicketDropdown = new Select(ticketSelectButton);
        selectTicketDropdown.selectByIndex(indexNumber);
    }

    public void enterPromocodeName(String promocodeName){
        promocodeText.sendKeys(promocodeName);
    }

    public void enterValidFromDate(Calendar calendar) throws Exception{
        validFromDateSelect.click();
        dateTimeSelector(calendar);
        Thread.sleep(1000);
        clickSetButton();
    }

    public void enterValidUptoDate(Calendar calendar) throws Exception{
        validUptoDateSelect.click();
        dateTimeSelector(calendar);
        Thread.sleep(1000);
        clickSetButton();
    }

    public void enterDiscountAmount(String discountMoney){
        discountAmountText.click();
        enterMoneyInDialogBox(discountMoney);
        clickSetButton();
    }

    public void enterAllowedUsageAmount(String allowedUsageMoney) throws Exception{
        scrollElementIntoView(driver,allowedUsageText);
        allowedUsageText.click();
        enterMoneyInDialogBox(allowedUsageMoney);
        clickSetButton();
    }


}
