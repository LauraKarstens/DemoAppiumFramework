package com.Framework;

import com.Framework.Listeners.AssertionLogging;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class iOSBrowserBase extends IOSBase {

    public static AssertionLogging softAssert = new AssertionLogging();

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
        String device = (String) prop.get("iOSDevice");
        //Telling Appium which device to use
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        //Telling Appium that we are using Android Studio UI Automator to access the browser and run test automation on the app
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        //Retrieving the browser name from the Global Properties and storing it
        String browserName =(String) prop.get("iOSBrowserName");
        //Telling Appium which browser we are using for testing
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        //Providing platform name and version (Maybe not needed?)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        //Getting the UDID value from global properties and storing it as a property
        String udid =(String) prop.get("UDID");
        //Providing the UDID for the device/simulator as required
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        //TODO refactor all global properties and variables so they are the same


//        //Providing platform name and version (Maybe not needed?)
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");


        //Setting up the driver
        String address =(String) prop.get("IP");
        URL url = new URL(address);
        AppiumDriver driver = new AppiumDriver(url, capabilities);
        return driver;
    }


}
