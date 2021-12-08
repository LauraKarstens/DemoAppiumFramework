package App;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.framework.base.Base;
import com.framework.base.Common;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

//This class contains random tests executed from the landing page
public class ExampleMobileTests extends Base {

//This test checks for the presence of all the elements we expect to be on the landing page. In this case, the header and buttons.
    @Test (description = "Checking that all buttons are present on the landing page", dataProvider = "LandingPageObjects")
    public void checkLandingPageObjects( String expectedText){

        //We are looking for the presence of specific elements based on the text field of the object
        //This test is looped for every {data set} in the data provider

        //I created the getTextViewByButtonText method so that it can be used anywhere in the code to get an element based on the text field
        WebElement element = android.getTextViewByButtonText(expectedText);
        //Using assertions to confirm the element is displayed
        softAssert.assertTrue(element.isDisplayed(), ""+expectedText+" button is present");
        softAssert.assertAll();
    }

    //The data provider for the above test.
    @DataProvider(name="LandingPageObjects")
    public static Object[][] getData()
    {
        //Below you can see multiple data sets, which will run through the test multiple times
        Object[][] data=new Object[][]
                {
                        {"API Demos"},
                        {"Accessibility"},
                        {"Animation"},
                        {"App"},
                        {"Content"},
                        {"Graphics"},
                        {"Media"},
                        {"NFC"},
                        {"OS"},
                        {"Preference"},
                        {"Text"},
                        {"Views"}
                };
        //Returning the data object
        return data;
    }

    //Checking that 2 buttons take us to the correct page when clicked
    @Test (groups= {"smoke"}, enabled = true, dataProvider= "ClickTestData", description = "Both buttons on the home screen lead to the correct page")
    public void checkButtonFunction(String buttonName, String desc, String buttonText, String message) throws InterruptedException, MalformedURLException {

        //Part of the xpath, expected text and message are given by the data provider
        WebElement element = driver.findElementByXPath("//android.widget.TextView[@content-desc='"+buttonName+"']");
        element.click();
        //Checking that the existing button text is the same as the expected text, and supplying a message for the Assertion
        //In this example, the message = "Checking Accessibility button text"
        //If the assertion fails it will print "Assertion: Checking animation button text <FAILED> "
        softAssert.assertEquals(android.getButtonText(desc), buttonText, message);
        //Pressing the "back" button on the device to return to the home screen
        driver.navigate().back();
        //Causes an exception to be thrown if any assertions fail, failing the test and printing information on the failure
        //This should be included in any method that contains assertions. SoftAssert is preferred over regular assertions
        softAssert.assertAll();
    }

    //The data provider for the above test, giving two sets of data. Notice there are 4 strings in each set, and we feed 4 arguments into the test method
    @DataProvider(name="ClickTestData")
    public static Object[][] getButton()
    {
        //Below you can see multiple data sets, which will run through the test multiple times
        Object[][] buttons=new Object[][]
                {
                        {"Accessibility", "Accessibility Node Provider", "Accessibility Node Provider", "Checking accessibility button text"},
                        {"Animation", "Bouncing Balls", "Bouncing Balls", "Checking animation button text"}
                };
        //Returning the data object
        return buttons;
    }

    // Below is another example of how a data provider could be structured
    @DataProvider(name="ClickTestData2")
    public static Object[][] getButton2()
    {
        Object[][] buttons=new Object[2][4]; //This shows the object as containing 2 rows and 4 columns

        // The first set of  data
        buttons[0][0]="Accessibility";
        buttons[0][1]="Accessibility Node Provider";
        buttons[0][2]="Accessibility Node Provider";
        buttons[0][3]="Checking accessibility button text";

        // The second set of data
        buttons[1][0]="Animation";
        buttons[1][1]="Bouncing Balls";
        buttons[1][2]="Bouncing Balls";
        buttons[1][3]="Checking animation button text";

        //Returning the data object
        return buttons;
    }

    //An example of using automation to fill text fields in a text entry dialog box
    @Test (groups= {"smoke"}, enabled = true, description = "We can enter text in the Text Entry Dialog")
    public void fillTextEntryDialog(){

        //Searching for an element and clicking on it, based on the page object
        android.getAppButton().click();
        android.getAlertDialogsButton().click();
        android.getTextEntryDialogButton().click();
        android.getUsernameField().click();

        //Filling the text field with a string
        android.getUsernameField().sendKeys("Username");
        // Checking that the element now contains the entered test
        softAssert.assertEquals(android.getUsernameField().getText(), "Username", "The username field is no longer empty");

        //Clicking the "ok" button to close the dialog
        android.getOkButton().click();

        //Returning to the landing page
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        softAssert.assertAll();
    }

    //Below is an example of a test that uses context switching to automate a hybrid app
    @Test(groups= {"smoke"}, enabled = true, description = "We are able to switch from native views to web views")
    public void checkWebView() throws InterruptedException, MalformedURLException {

        //Clicking on the "Views" button from the landing page
        android.getViewsButton().click();

        //Swiping the screen twice to scroll
        common.swipeScreen(Common.Direction.UP);
        common.swipeScreen(Common.Direction.UP);

        //Clicking on the "WebView" button
        android.getWebViewButton().click();

        //Switching to WebView context so that we can interact in web view
        common.switchToWebContext();

        //Clicking the hyperlink in WebView
        android.getHyperlink().click();

        //Assertion to test that the correct text appears on the following Web View
        softAssert.assertEquals(android.getWebViewTextElement().getText(), "I am some other page content", "Checking that the web view text is correct");

        //Navigating back to the app
        driver.navigate().back();
        //Switching back to Native App Views for app interaction
        common.switchToNativeContext();
        //Navigating back to the landing page to reset for the next tests
        driver.navigate().back();
        driver.navigate().back();

        //Causes an exception to be thrown if any assertions fail, failing the test and printing information on the failure
        //This should be included in any method that contains assertions. SoftAssert is preferred over regular assertions
        softAssert.assertAll();
    }

    //Using a common click and drag method to change the time on an analog clock and check that the time was successfully changed
    @Test (description = "Utilizing Click and Drag to change an analog clock time")
    public void changeAnalogClockTime(){

        //Clicking on the Views button
        android.getViewsButton().click();
        //Clicking on Date Widgets
        android.getDateWidgetsButton().click();
        //Clicking Inline
        android.getInlineButton().click();

        //Long press on hour hand and move to second hour hand
        common.clickAndDrag(android.getAnalogClockNumber(12), android.getAnalogClockNumber(4));
        //Repeat for minute hand
        common.clickAndDrag(android.getAnalogClockNumber(15), android.getAnalogClockNumber(30));

        //Check displayed clock time with assertion
        softAssert.assertTrue(android.getDigitalClockText("4").isDisplayed(), "The hour has been changed");
        softAssert.assertTrue(android.getDigitalClockText("30").isDisplayed(), "The minute has been changed");

        //Navigate back to landing, back x3
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        //Assert
        softAssert.assertAll();
    }

    //Using a search bar to filter a list and verify the returned results
    @Test (description = "Search bar/filtering functionality and verification")
    public void verifySearchFiltering(){

        //clicking the Views button
        android.getViewsButton().click();
        //Scroll?
        common.swipeScreen(Common.Direction.UP);
        //clicking the Search View button
        android.getSearchViewButton().click();
        //clicking the Filter button
        android.getFilterButton().click();

        //Entering a search string in the search bar to filter the list
        android.getSearchBarEntryField().sendKeys("Abb");

        //Verify results.
        // Get the list of search results. For each element in the list, get the text and check that it starts with our search string
        for (WebElement element : android.getSearchResultsList()) {
            softAssert.assertTrue(element.getText().startsWith("Abb"));
        }

        //Returning to the landing page
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        //Asserting all
        softAssert.assertAll();
    }

    //Testing that a button changes state when clicked
    @Test (description = "Testing button state change when clicking button")
    public void testButtonStateChange(){

        //Clicking Views button
        android.getViewsButton().click();
        //Clicking Buttons button
        android.getButtonsButton().click();

        //Verify the button resting state is as expected
        softAssert.assertEquals(android.getToggleButton().getText(), "OFF", "The toggle button defaults to the OFF state");
        //Clicking Off button
        android.getToggleButton().click();
        //Verifying that the button state has changed after being clicked
        softAssert.assertEquals(android.getToggleButton().getText(), "ON", "The toggle button changes to the ON state");
        //Clicking On button
        android.getToggleButton().click();
        //Verifying the button has returned to default state after final click
        softAssert.assertEquals(android.getToggleButton().getText(), "OFF", "The toggle button returned to the OFF state");

        //Navigating back to landing page (back x2?)
        driver.navigate().back();
        driver.navigate().back();

        //Assertion
        softAssert.assertAll();
    }

    //Using a calendar date picker. Selecting a new date dynamically based on the today's date.
    @Test (description = "Using a date picker/Calendar to dynamically change the date to tomorrow and dynamically verify it")
    public void datePickerTest(){

        //Clicking Views button
        android.getViewsButton().click();
        //Clicking Date Widgets button
        android.getDateWidgetsButton().click();
        //Clicking Dialog button
        android.getDialogButton().click();
        //Clicking the Change the date button
        android.getChangeTheDateButton().click();

        //Selecting a new date dynamically, based on the current date (which is always today's date)
        //This happens in the below page object method getTomorrowsDateButton()
        android.getTomorrowsDateButton().click();
        //clicking OK to save the new date
        android.getDateOkButton().click();

        //Verifying that the date has been changed by checking that the element text starts with the correct date
        //The string we verify against is also dynamically generated in getTomorrowsDateString()
        softAssert.assertTrue(android.getDateDisplay().getText().startsWith(android.getTomorrowsDateString()), "The date has been changed to tomorrow");

        //Returning to the landing page
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        //Assertion
        softAssert.assertAll();
    }
}

