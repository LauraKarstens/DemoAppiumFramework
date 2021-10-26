package com.Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSBase extends Base {

    public static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static IOSDriver DesiredCapabilities() throws IOException {

        // Creates a FileInputStream by opening a connection to an actual file, the file named by the path name in the file system
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Framework/global.properties");
        // Creates an empty property list with no default values.
        Properties prop=new Properties();
        //Reads a property list (key and element pairs) from the input stream.
        prop.load(fis);
        //Retrieving the pathname for the folder containing the app file and storing it as a property
        String directory=(String) prop.get("appDir");
        //Supplying the pathname for the app file as stored previously
        File appDir = new File(directory);
        //Retrieving the App Name from Global Properties and storing it as a property
        File app = new File(appDir, (String) prop.get("iOSApp"));
        // Retrieving the device name from Global Properties and storing it as a property
        String device = (String) prop.get("iosDevice");

        //Setting all the properties below
        //Telling Appium which device to use based on the property we set earlier
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        //Getting the UDID value from global properties and storing it as a property
        String udid =(String) prop.get("UDID");
        //Providing the UDID for the device/simulator as required
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        //Telling Appium that we are using XCUI Test via XCode to run test automation on the app
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        //This defines how long Appium should wait for a new command from the client before assuming the client ended the session
        //Set to 0 to disable the timeout, but this isn't recommended as it allows automation sessions to continue indefinitely
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30);
        //Telling Appium where to find the application for testing
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //TODO testing on pre-installed apps and physical devices, How easy is it to open a pre-installed app rather than one hosted here

        //Setting up the driver
        String address=(String) prop.get("IP");
        IOSDriver driver = new IOSDriver<>(new URL(address), capabilities);
        return driver;
    }
}
