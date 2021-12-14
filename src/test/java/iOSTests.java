import com.framework.base.Base;
import org.testng.annotations.*;
import pageObjects.AppPageObjects;

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

    //This tests an alert pop up
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

    //Testing that we can fill a text entry dialog
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

    //This test handles switching to web view, doing an assertion and switching back to native view when testing hybrid apps
    @Test(description = "Checking that the web view loads as expected on a hybrid application", enabled = false)
    public void webViewTest() {

        /*NOTE: This test WILL NOT run and is therefore disabled. This is due to issues in the app code that prevent us from inspecting the web view
                so that we can identify elements. I wanted to leave the example here for general structure and an idea of switching contexts
                on a hybrid app. */

        //Clicking on WebView
        ios.getWebViewButton().click();
        //Switching to the WebView context
        common.switchToWebContext();

        //Assertion on the text in the web view to make sure it works as expected
        softAssert.assertTrue(ios.getWebViewText().isDisplayed(), "The web view text is displayed");

        //Navigating back to the Native App
        driver.navigate().back();
        //Switching back to the Native context
        common.switchToNativeContext();

        //Assertion on landing page button to check that we are back in the native app view
        softAssert.assertTrue(ios.getWebViewButton().isDisplayed(), "We are on the landing page (Web view button is present)");

        softAssert.assertAll();
    }

    //Using a calendar/date picker to change the date dynamically based on the currently selected date (today)
    @Test(description = "Using a calendar/date picker to change the date dynamically")
    public void datePickerTest() {

       /* NOTE: This test will fail on the last day of the month due to the app design being less than desirable.
                The app does not allow the user to select a date in the past which we would not typically have in an app.
                If we did have that scenario we would want to include logic that picks the next month if the new date is in the next month. */

        //Clicking Views button
        ios.getDatePickerButton().click();
        //Clicking Date Widgets button
        ios.getCalendarButton().click();

        //Selecting a new date dynamically, based on the current date (which is always today's date)
        //This happens in the below page object method getTomorrowsDateButton()
        ios.getTomorrowsDateButton().click();
        //clicking OK to save the new date
        ios.getEmptySpace();

        //Verifying that the date has been changed by checking that the element text starts with the correct date
        //The string we verify against is also dynamically generated in getTomorrowsDateString()
        softAssert.assertTrue(ios.getCalendarButton().getText().contains(AppPageObjects.getTomorrowsDateString()), "The date has been changed to tomorrow");

        //Returning to the landing page
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        //Assertion
        softAssert.assertAll();
    }

    //This test uses click and drag to change a segmented control, and verifies which control is currently selected
    @Test(description = "Segmented controls can be changed as expected")
    public void controlChangeTest() {

        //Click Segmented Controls button
        ios.getSegmentedControlsButton().click();

        //Click and drag from the Search element to the Tools element
        common.clickAndDrag(ios.getSearchControlButton(),ios.getToolsControlButton());

        //Verify that the 'tools' element now has a value of 1. This is how the dev flagged the selected control.
        //I found this out through experimentation and comparison of the xpaths between selected and non-selected elements
        //We are searching for the control with the value of 1 and then checking that it is the element we expected by getting its name
        softAssert.assertEquals(ios.getSelectedControl().getAttribute("name"), "Tools", "The control was changed as expected");

        //Returning to the landing page
        driver.navigate().back();

        softAssert.assertAll();
    }
}
