import com.framework.base.Base;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.*;

import java.io.IOException;

public class iOSTests extends Base {

    //This test is looped through due to the data provider
    //Checking for the presence of several buttons on a page
    @Test (description = "Checking that the expected buttons are on the page", dataProvider = "expectedButtons")
    public void checkButtonsViewElements(String nth, String buttonName, int i) {

        //Clicking the "Buttons" button
        ios.getButtonsButton().click();

        //Checking that the element is displayed
        softAssert.assertTrue(ios.getButtonByName(buttonName, i).isDisplayed(), "The "+nth+" button is displayed");

        //Navigating back to the landing page
        driver.navigate().back();

        softAssert.assertAll();
    }

    @DataProvider(name="expectedButtons")
    public static Object[][] getData()
    {
        //Below you can see multiple data sets, which will run through the test multiple times
        Object[][] data=new Object[][]
                {
                        {"First", "Button", 1},
                        {"Second", "add", 1},
                        {"Third", "More Info", 1},
                        {"Fourth", "X Button", 1},
                        {"Fifth", "Button", 2},
                        {"Sixth", "Person", 1},
                        {"Seventh", "Button", 3},
                };
        //Returning the data object
        return data;
    }

    @Test(description = "Testing an alert / pop up")
    public  void alertTest(){
        //Clicking the Alert Views button
        ios.getAlertViewsButton().click();
        //Clicking the Simple button to open a simple alert
        ios.getSimpleButton().click();

        //Asserting against the alert Title text
        softAssert.assertEquals(ios.getAlertHeader().getText(), "A Short Title Is Best", "The alert and alert title display as expected");

        //Clicking OK on the alert
        ios.getOkButton().click();
        //Navigating back to the landing page
        driver.navigate().back();

        softAssert.assertAll();
    }

    @Test(description = "Filling a text entry dialog")
    public  void textEntryTest(){
        //Clicking the Alert Views button
        ios.getAlertViewsButton().click();
        //Clicking the Text Entry button
        ios.getTextEntryButton().click();

        //Entering Text in the text field
        ios.getTextEntryField().sendKeys("Test String");

        //Checking that the entered text is now present within the element
        softAssert.assertEquals(ios.getTextEntryField().getText(), "Test String","The text was entered in the field");

        //Clicking the OK button
        ios.getOkButton().click();
        //Navigating back to the main menu
        driver.navigate().back();

        softAssert.assertAll();
    }

    //This test increments and decrements a counter and checks that the associated value has changed accordingly
    @Test(description = "Incrementing and decrementing a counter/stepper and checking the value dynamically")
    public  void incrementTest() {

        //Clicking Steppers button
        ios.getSteppersButton().click();

        //Getting the current integer and setting storing it
        //Converting the string from .getText() to an integer so we can add 1 to it later
        int counterValue = Integer.parseInt(ios.getCounterNumber().getText());

        //Pressing the + button to increment the counter by 1
        ios.getIncrementButton().click();

        //Checking the new value of the counter by taking the old value and adding 1 to it (that way it doesn't depend on the counter starting at 0)
        //Converting the expected integer back to a string for comparison
        String newCounterValue = Integer.toString(counterValue + 1);
        //Checking the new counter value against the actual counter value after using the increment button
        softAssert.assertEquals(ios.getCounterNumber().getText(), newCounterValue, "We are able to increment the counter");

        //Pressing the - button to decrement the counter by 1 and return it to the original value
        ios.getDecrementButton().click();

        //Converting the expected integer back to a string for comparison.
        String finalCounterValue = Integer.toString(counterValue);

        //Checking the original counter value against the current value
        softAssert.assertEquals(ios.getCounterNumber().getText(),finalCounterValue, "We are able to decrement the counter");

        //Navigating back to the landing page
        driver.navigate().back();

        softAssert.assertAll();
    }


    //Date Picker
    //WebView
    //TODO look into multiple app  installs and WebDriverAgent?

}
