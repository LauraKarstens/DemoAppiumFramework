package pageObjects;

import com.framework.base.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppPageObjects extends Base {

    public static WebElement getButtonsButton() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Buttons']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getButtonByName(String name, int i) {
        //providing the xpath as a string
        String xpath = "(//XCUIElementTypeButton[@name='"+name+"'])["+i+"]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getAlertViewsButton() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Alert Views']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getSimpleButton() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Simple']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getOkButton() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeButton[@name='OK']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getAlertHeader() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeAlert[@name='A Short Title Is Best']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getTextEntryButton() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Text Entry']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getTextEntryField() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeTextField";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getSteppersButton() {
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Steppers']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getIncrementButton() {
        //providing the xpath as a string
        String xpath = "(//XCUIElementTypeButton[@name='Increment'])[1]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getDecrementButton() {
        //providing the xpath as a string
        String xpath = "(//XCUIElementTypeButton[@name='Decrement'])[1]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getCounterNumber(){
        //providing the xpath as a string
        String xpath = "(//XCUIElementTypeStaticText)[2]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getWebViewButton(){
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Web View']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getWebViewText(){
        //providing the xpath as a string
        //String xpath = "//XCUIElementTypeStaticText[@name=\"WKWebView\"]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByAccessibilityId("This is HTML content inside a"), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByAccessibilityId("This is HTML content inside a");
        return element;
    }

    public static WebElement getDatePickerButton(){
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Date Picker']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getCalendarButton(){
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeOther[@name='Date and Time Picker']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    //Dynamically selecting the day after the currently selected day
    public static WebElement getTomorrowsDateButton(){
        //Dynamically setting a string to tomorrow's date so that we can find the right element to click in the calendar

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d");
        //Converting tomorrow's date to a string for use in dynamically finding the correct element
        //We are also formatting the date here to the above format, as required by the app
        String tomorrowsDateString= dateFormat.format(tomorrowsDate);
        System.out.println(tomorrowsDateString);

        //Finding the right button based on tomorrow's date
        WebElement tomorrowsDateButton = driver.findElementByXPath("//XCUIElementTypeButton[@name='"+tomorrowsDateString+"']");
        return tomorrowsDateButton;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d");
        //Converting tomorrow's date to a string for use in assertion and formatting it to match the app date format
        String tomorrowsDateString= dateFormat.format(tomorrowsDate);
        return tomorrowsDateString;
    }

    public void getEmptySpace(){
        new TouchAction(driver)
                .press(PointOption.point(-80, 148))
                .release()
                .perform();
        System.out.println("Clicked empty space to leave prompt");
    }

    public static WebElement getSegmentedControlsButton(){
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeStaticText[@name='Segmented Controls']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getSearchControlButton(){
        //providing the xpath as a string
        String xpath = "(//XCUIElementTypeButton[@name='Search'])[2]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getToolsControlButton(){
        //providing the xpath as a string
        String xpath = "(//XCUIElementTypeButton[@name='Tools'])[2]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

    public static WebElement getSelectedControl(){
        //providing the xpath as a string
        String xpath = "//XCUIElementTypeButton[@value='1']";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }
}
