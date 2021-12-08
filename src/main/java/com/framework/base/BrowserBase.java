package com.framework.base;

import com.framework.listeners.AssertionLogging;
import com.pageObjects.BrowserPageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;

public class BrowserBase {

    //    The driver can also be called from any Class that extends Base
    public static AppiumDriver driver;

    // The below objects can be used in your code to access methods from the respective Classes from any Class that extends Base.
    // (e.g. assertions, page objects and commonly used methods)
    public static BrowserPageObjects chrome = new BrowserPageObjects();
    public static AssertionLogging softAssert = new AssertionLogging();
    public static Common common = new Common();

    {
        try {
            driver = capabilities();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver capabilities() throws IOException {
        // Creates a FileInputStream by opening a connection to an actual file, the file named by the path name in the file system
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Framework/global.properties");
        // Creates an empty property list with no default values.
        Properties prop=new Properties();
        //Reads a property list (key and element pairs) from the input stream.
        prop.load(fis);

        // Initializing Desired Capabilities, which is what we utilize to set properties for our testing.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Setting all the properties below
        // Retrieving the device name from Global Properties and storing it as a property
        String device = (String) prop.get("androidDevice");
        //Retrieving the mobile browser driver path and storing it
        String driverPath =(String) prop.get("driverPath");
        //Telling Appium which device to use
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        //Telling Appium that we are using Android Studio UI Automator to access the browser and run test automation on the app
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        //Providing the capability name we are setting (Chrome Driver Executable ) as well as the file path to the chrome driver
        capabilities.setCapability("chromedriverExecutable",driverPath);
        //Providing platform name
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //Telling Appium not to re-install the browser app every time we test
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        //Getting the mobile browser property from Global Properties and saving it to a string
        String mobileBrowser =(String) prop.get("mobileBrowser");
        //Telling Appium which browser we are using for testing
        if (Objects.equals(mobileBrowser, "Samsung")) {
            //This sets up Samsung Internet Browser
            capabilities.setCapability("appPackage", "com.sec.android.app.sbrowser");
            capabilities.setCapability("appActivity", "com.sec.android.app.sbrowser.SBrowserMainActivity");
        } else if (Objects.equals(mobileBrowser, "Chrome")){
            //This sets up Chrome
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        }

        //Setting up the driver
        String address=(String) prop.get("IP");
        driver = new AppiumDriver(new URL(address), capabilities);
        return driver;
    }
}
