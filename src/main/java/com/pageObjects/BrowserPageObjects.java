package com.pageObjects;

import com.framework.base.Base;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

public class BrowserPageObjects extends Base {

    public static WebElement getHomeButton() {
        //Providing the xpath as a string
        String xpath = "//icon[@class='nav-logo lazy-loaded']";
        //Waiting for the presence of the desired element
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        //Creating a Web Element object to return
        WebElement homeButton = driver.findElementByXPath(xpath);
        //Returning the web element for use in testing
        return homeButton;
    }

    public static String getWelcomeMessage() {
        String xpath = "//h1[@class='hero__headline hero__headline--basic']";
        common.waitForElement(driver.findElementByXPath(xpath), 10, 1);
        WebElement welcomeMessage = driver.findElementByXPath(xpath);
        String text = welcomeMessage.getText();
        return text;
    }
}
