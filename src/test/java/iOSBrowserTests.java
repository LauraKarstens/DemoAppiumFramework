import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class iOSBrowserTests extends com.framework.base.BrowserBase {

    @Test (dataProvider= "BrowserTestData", description = "Checking the LinkedIn Welcome Message text")
    public void checkWelcomeMessage(String expected) throws IOException, InterruptedException {
        // Telling the driver to navigate to a specific URL=
        driver.get("https://linkedin.com");
        // Using page objects to identify an element and click on that element
        safari.getHomeButton().click();
        //Comparing the text of that element to the expected text, and providing a message that describes the assertion
        softAssert.assertEquals(safari.getWelcomeMessage(), expected, "Checking the welcome message");

        //Causes an exception to be thrown if any assertions fail, failing the test and printing information on the failure
        //This should be included in any method that contains assertions. SoftAssert is preferred over regular assertions
        softAssert.assertAll();
    }

    @DataProvider(name="BrowserTestData")
    public static Object[][] getWelcomeMessage()
    {
        //You can store many values here as an array, or just one
        Object expected[][]=new Object[][]
                {
                        {"Welcome to your professional community"}
                };
        //Returning the data object
        return expected;
    }
}