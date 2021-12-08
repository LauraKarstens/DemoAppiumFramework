package com.pageObjects;

import com.framework.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppPageObjects extends Base {

	public static String getButtonText(String desc){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='"+desc+"']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Getting the text from the specified web element
		String text = element.getText();
		//Returning the text for use in testing
		return text;
	}

	public static WebElement getViewsButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='Views']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getWebViewButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='WebView']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getHyperlink(){
		//Providing the xpath as a string
		String xpath = "//*[@id=\"i am a link\"]";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getWebViewTextElement(){
		//Providing the xpath as a string
		String xpath = "/html/body[contains(text(),'I am some other page content')]";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getAppButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='App']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getAlertDialogsButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='Alert Dialogs']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getTextEntryDialogButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.Button[@text='Text Entry dialog']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getUsernameField(){
		//Providing the xpath as a string
		String xpath = "//android.widget.EditText[@resource-id='io.appium.android.apis:id/username_edit']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getOkButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.Button[@resource-id='android:id/button1']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	//Identifying the element based on xpath text provided by the data provider
	public static WebElement getTextViewByButtonText(String text){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='"+text+"']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getDateWidgetsButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='Date Widgets']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getInlineButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text='2. Inline']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getAnalogClockNumber(int number){
		//Providing the xpath as a string
		String xpath = "//*[@content-desc="+number+"]";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getDigitalClockText(String number){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@text="+number+"]";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getSearchViewButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@content-desc='Search View']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getFilterButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@content-desc='Filter']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getSearchBarEntryField(){
		//Providing the xpath as a string
		String xpath = "//android.widget.EditText[@resource-id='android:id/search_src_text']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static List<WebElement> getSearchResultsList(){
		//Providing the xpath as a string
		String xpath = "//android.widget.ListView/*";
		//Creating a List of matching web elements
		List<WebElement> elementList = driver.findElements(By.xpath(xpath));
		//Returning the list of elements for use in testing
		return elementList;
	}

	public static WebElement getButtonsButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@content-desc='Buttons']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getToggleButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.ToggleButton[@content-desc='Toggle']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getDialogButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@content-desc='1. Dialog']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getChangeTheDateButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.Button[@content-desc='change the date']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	//Dynamically selecting the day after the currently selected day
	public static WebElement getTomorrowsDateButton(){
		//Providing the xpath as a string
		String xpath = "//android.view.View[@checked='true']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Getting the text/number from "today's" date (a.k.a the CURRENTLY selected date) and storing it as an integer
		int date = Integer.parseInt(element.getText());

		//Adding one to that integer to ensure we are selecting the next day.
		//I added a check to ensure we won't run into an error if the current date is the last day of the month
		int tomorrow = 0;
		if (date<28) {
			//If the current date is any day but the last day of the month (accounting for February), add one to that date
			tomorrow = date + 1;
		} else {
			//If the current date is possibly the last day of the month, select the previous date instead
			tomorrow = date - 1;
		}

		//Setting the element object to the new xpath, that contains tomorrows date
		element = driver.findElementByXPath("//android.view.View[@text='"+tomorrow+"']");
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getDateOkButton(){
		//Providing the xpath as a string
		String xpath = "//android.widget.Button[@text='OK']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static WebElement getDateDisplay(){
		//Providing the xpath as a string
		String xpath = "//android.widget.TextView[@resource-id='io.appium.android.apis:id/dateDisplay']";
		//Waiting for the presence of the desired element
		common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
		//Creating a Web Element object
		WebElement element = driver.findElementByXPath(xpath);
		//Returning the element for use in testing
		return element;
	}

	public static String getTomorrowsDateString(){
		//Dynamically setting a string to tomorrow's date so that we can check it in the assertion.

		//Creating a date object
		Date currentDate = new Date();
		//Creating a calendar instance
		Calendar calendar = Calendar.getInstance();
		//Setting the date object to the current date
		calendar.setTime(currentDate);

		//We have to account for the possibility that it's the last day of the month. If so, we select the previous day instead
		if (calendar.get(Calendar.DATE)<28) {
			//Adding one date to the current date
			calendar.add(Calendar.DATE, 1);
		} else {
			//Subtracting one date from the current date
			calendar.add(Calendar.DATE, -1);
		}

		//Creating a new date object and setting it to the new date
		Date tomorrowsDate = calendar.getTime();
		//Creating the date format object and setting the desired format based on the app date format
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-d-yyyy");
		//Converting tomorrow's date to a string for use in assertion and formatting it to match the app date format
		String tomorrowsDateString= dateFormat.format(tomorrowsDate);
		return tomorrowsDateString;
	}
}
