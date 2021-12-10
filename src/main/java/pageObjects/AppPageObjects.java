package pageObjects;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;

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
        //String xpath = "(//XCUIElementTypeCell//XCUIElementTypeStaticText)[1]";
        String xpath = "(//XCUIElementTypeStaticText)[2]";
        //waiting for the element to load
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating the WebElement object and returning it for use in testing
        WebElement element = driver.findElementByXPath(xpath);
        return element;
    }

}
