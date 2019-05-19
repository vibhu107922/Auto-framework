package com.nwp.basePage;

import com.nwp.utils.ProjectUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.function.Function;

public class NWPBasePage implements BasePageCommonConstants {

    private WebDriver driver;

    public static <T> void setFluentWait(WebDriver driver,
	    Function<? super WebDriver, T> condition, int timeoutInSeconds) {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(timeoutInSeconds))
		.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
	wait.until(condition);
    }

    public NWPBasePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }

    public NWPBasePage() {

    }

    @FindBy(css = dialogBoxCss)
    WebElement dialogBox;

    @FindBy(css = confirmDiaglogBoxCss)
    WebElement confirmDialogBox;

    @FindBy(css = setCss)
    WebElement setButton;

    @FindBy(css = monthCss)
    WebElement monthOption;

    @FindBy(css = dateCss)
    WebElement dateOption;

    @FindBy(css = yearCss)
    WebElement yearOption;

    @FindBy(css = hourCss)
    WebElement hourOption;

    @FindBy(css = minuteCss)
    WebElement minuteOption;

    @FindBy(xpath = ampmXpath)
    WebElement ampmOption;

	@FindBy(css = moneyOptionParent)
	WebElement enterMoney;

    public static int standardTimeOut = 30;

    public boolean dialogBoxContainsSuccess() {
	setFluentWait(driver,
		ExpectedConditions.elementToBeClickable(confirmDialogBox),
		standardTimeOut);
	return dialogBox.getText().toLowerCase().contains("success");
    }

    public void confirmDialogBox() {
	setFluentWait(driver,
		ExpectedConditions.elementToBeClickable(confirmDialogBox),
		standardTimeOut);
	confirmDialogBox.click();
    }

    public void clickSetButton() {
	setButton.click();
    }

    public void dateTimeSelector(Calendar calendar) {
	String date = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	String year = String.valueOf(calendar.get(Calendar.YEAR));
	String month = String.valueOf(calendar.get(Calendar.MONTH));
	String ampm = String.valueOf(calendar.get(Calendar.AM_PM));
	String hour = String.valueOf(calendar.get(Calendar.HOUR));
	String minutes = String.valueOf(calendar.get(Calendar.MINUTE));
	List<WebElement> dateOptions = dateOption
		.findElements(By.cssSelector(optionCss));
	List<WebElement> yearOptions = yearOption
		.findElements(By.cssSelector(optionCss));
	List<WebElement> monthOptions = monthOption
		.findElements(By.cssSelector(optionCss));
	List<WebElement> ampmOptions = ampmOption
		.findElements(By.cssSelector(optionCss));
	List<WebElement> hourOptions = hourOption
		.findElements(By.cssSelector(optionCss));
	List<WebElement> minutesOptions = minuteOption
		.findElements(By.cssSelector(optionCss));

	ProjectUtilities.clickMatchingAttributeElement(dateOptions, indexAttribute, String.valueOf(Integer.parseInt(date)-1));
	ProjectUtilities.clickMatchingAttributeElement(yearOptions, indexAttribute, year);
	ProjectUtilities.clickMatchingAttributeElement(monthOptions, indexAttribute, month);
	ProjectUtilities.clickMatchingAttributeElement(ampmOptions, indexAttribute, ampm);
	ProjectUtilities.clickMatchingAttributeElement(hourOptions, indexAttribute, hour);
	ProjectUtilities.clickMatchingAttributeElement(minutesOptions, indexAttribute, minutes);
    }


	public void enterNumber(char[] numbersToBeEntered){
    	List<WebElement> numberElements = enterMoney.findElements(By.cssSelector(buttonCss));
    	for(int i=0; i<numbersToBeEntered.length; i++){
			ProjectUtilities.clickMatchingAttributeElement(numberElements, dataValAttribute,String.valueOf(numbersToBeEntered[i]));
		}
	}

	public void enterMoneyInDialogBox(String moneyToBeEntered, boolean enterInDecimalMode){
		if(enterInDecimalMode) {
			if (!moneyToBeEntered.contains(".")) {
				moneyToBeEntered = moneyToBeEntered + ".00";
			}
			moneyToBeEntered = ProjectUtilities.removeCharFromString(moneyToBeEntered,'.');
		}
		char[] individualCharacterArray = moneyToBeEntered.toCharArray();
		enterNumber(individualCharacterArray);
	}
}
