import java.net.MalformedURLException;
import com.framework.base.Base;
import com.framework.base.Common.Direction;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class AndroidTests extends Base {

    @Test (groups= {"smoke"}, enabled = true, dataProvider= "ClickTestData", description = "Both buttons on the home screen lead to the correct page")
    public void checkButtonFunction(String buttonName, String desc, String buttonText, String message) throws InterruptedException, MalformedURLException {
        //Searching for an element and clicking on it, based on the xpath which is partially supplied by the data provider
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

    //Below is an example of a test that uses context switching to automate a hybrid app
    @Test (groups= {"smoke"}, enabled = true, description = "We are able to switch from native views to web views")
    public void checkWebView() throws InterruptedException, MalformedURLException {

        //Clicking on the "Views" button from the landing page
        android.getViewsButton().click();

        //Swiping the screen twice to scroll
        common.swipeScreen(Direction.UP);
        common.swipeScreen(Direction.UP);

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

        //Causes an exception to be thrown if any assertions fail, failing the test and printing information on the failure
        //This should be included in any method that contains assertions. SoftAssert is preferred over regular assertions
        softAssert.assertAll();
    }
}

