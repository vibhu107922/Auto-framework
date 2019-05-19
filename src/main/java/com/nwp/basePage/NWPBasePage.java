package com.nwp.basePage;

import com.nwp.utils.ProjectUtilities;
import org.openqa.selenium.By;
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

    public void dateTimeSelector(Calendar calendar) throws Exception {
	String date = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	String year = String.valueOf(calendar.get(Calendar.YEAR));
	String month = String.valueOf(calendar.get(Calendar.MONTH));
	String ampm = String.valueOf(calendar.get(Calendar.AM_PM));
	String hour = String.valueOf(calendar.get(Calendar.HOUR));
	String minutes = String.valueOf(calendar.get(Calendar.MINUTE));

	List<WebElement> dateOptions = ProjectUtilities.filterListOfWebElements(dateOption
		.findElements(By.cssSelector(optionCss)),indexAttribute,0);
	List<WebElement> yearOptions = ProjectUtilities.filterListOfWebElements(yearOption
		.findElements(By.cssSelector(optionCss)),indexAttribute,0);
	List<WebElement> monthOptions = ProjectUtilities.filterListOfWebElements(monthOption
		.findElements(By.cssSelector(optionCss)),indexAttribute,0);
	List<WebElement> ampmOptions = ampmOption
		.findElements(By.cssSelector(optionCss));
	List<WebElement> hourOptions = ProjectUtilities.filterListOfWebElements(hourOption
		.findElements(By.cssSelector(optionCss)),indexAttribute,0);
	List<WebElement> minutesOptions = ProjectUtilities.filterListOfWebElements(minuteOption
		.findElements(By.cssSelector(optionCss)),indexAttribute,0);

	Thread.sleep(2000);

	WebElement selectedDateElement = ProjectUtilities.searchElementInList(dateOptions,"aria-selected","true");
	WebElement expectedDateElement = ProjectUtilities.searchElementInList(dateOptions,indexAttribute,String.valueOf(Integer.parseInt(date)-1));
	clickAndScrollTillYouFindYourElement(dateOptions,selectedDateElement,expectedDateElement);

	WebElement selectedMonthElement = ProjectUtilities.searchElementInList(monthOptions,"aria-selected","true");
	WebElement expectedMonthElement = ProjectUtilities.searchElementInList(monthOptions,indexAttribute,month);
	clickAndScrollTillYouFindYourElement(monthOptions,selectedMonthElement,expectedMonthElement);

	WebElement selectedYearElement = ProjectUtilities.searchElementInList(yearOptions,"aria-selected","true");
	WebElement expectedYearElement = ProjectUtilities.searchElementInList(yearOptions,indexAttribute,year);
	clickAndScrollTillYouFindYourElement(yearOptions,selectedYearElement,expectedYearElement);

	WebElement selectedHourElement = ProjectUtilities.searchElementInList(hourOptions,"aria-selected","true");
	WebElement expectedHourElement = ProjectUtilities.searchElementInList(hourOptions,indexAttribute,hour);
	clickAndScrollTillYouFindYourElement(hourOptions,selectedHourElement,expectedHourElement);

	WebElement selectedMinutesElement = ProjectUtilities.searchElementInList(minutesOptions,"aria-selected","true");
	WebElement expectedMinutesElement = ProjectUtilities.searchElementInList(minutesOptions,indexAttribute,minutes);
	clickAndScrollTillYouFindYourElement(minutesOptions,selectedMinutesElement,expectedMinutesElement);

	ProjectUtilities.clickMatchingAttributeElement(driver, ampmOptions, indexAttribute, ampm);
    }


	public void enterNumber(char[] numbersToBeEntered){
    	List<WebElement> numberElements = enterMoney.findElements(By.cssSelector(buttonCss));
    	for(int i=0; i<numbersToBeEntered.length; i++){
			ProjectUtilities.clickMatchingAttributeElement(driver, numberElements, dataValAttribute,String.valueOf(numbersToBeEntered[i]));
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

	public void clickAndScrollTillYouFindYourElement(List<WebElement> listOfElementsToBeTraversed, WebElement elementCurrentlySelected, WebElement elementToBeSelected) throws Exception{
		int foundSelectedElementIndex = listOfElementsToBeTraversed.indexOf(elementCurrentlySelected);
		int expectedSelectedElementIndex = listOfElementsToBeTraversed.indexOf(elementToBeSelected);
		while(expectedSelectedElementIndex!=foundSelectedElementIndex){
		if(foundSelectedElementIndex>expectedSelectedElementIndex)
			foundSelectedElementIndex--;
		else
			foundSelectedElementIndex++;
		listOfElementsToBeTraversed.get(foundSelectedElementIndex).click();
		Thread.sleep(1000);
		}
	}
}
