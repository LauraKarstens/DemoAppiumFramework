### NOTE: Framework and README are under construction

# Appium Framework for Android

This branch includes the appium framework for Android Apps and Browsers. Please see the README on the main branch for installation and setup instructions: 
[Here](https://github.com/madison-vincent/DemoAppiumFramework#readme)

[Here](https://github.com/madison-vincent/DemoAppiumFramework/tree/androidTesting) is a branch that has many example tests and interactions for Android

### Project Outline

[main > java > com > framework > base] This is where the majority of the framework lives. The Base class is where we set up the Appium Driver and give Appium all of the settings it needs to run automation on a mobile app. The BrowserBase class is where we set up the Driver and settings for mobile browsers. The Common class contains methods that are commonly used in the project, but not specific to a certain area or class. 

[main > java > com < framework > listeners] This is where the configuration lives for TestNG and the report that is generated with testing results. You can use the AssertionLogging class to change what happens when assertions pass or fail during a test. You can use the Listeners class to change what happens when tests start, end, pass, fail, are skipped, etc. I'd recommend just leaving the ExtentReporterNG class alone. 

[main > java > com < framework > pageObjects] This is where page objects live. Page objects are elements within the app, such as a button, that you want to interact with. We keep them separate from the tests so that we can reference the same object in multiple places without having redundant code. Page Objects should be organized into packages/folders and classes in a logical manner. Place page objects from similar tests or areas in the same Class. 
If you are unfamiliar with the page object model check out this link: [click here](https://www.browserstack.com/guide/page-object-model-in-selenium)

[main > resources] This is where your mobile chromedriver lives and where your app lives, assuming you are installing the app through the project with an .apk file. If you want to open an app that is already installed on the emulator/device there is code you can look at in the Base class for reference. 

[test > java] This is where the test classes live. You can create additional packages/folders in this location to organize your tests by area, or however you want. You will find example tests in the classes within this folder. 

[test-output > Reports] This is where a report will generate every time you run tests. right click the report (htmlreport.html) > Open in > Browser > Pick a browser

[test-output > Screenshots] This is where screenshots are saved when assertions fail

[.gitignore] This file tells git what parts of your project to ignore and leave out of the remote repository. Add to it as you see fit.

[pom.xml] This is where dependencies are managed. You can change version numbers here for different dependencies, such as TestNG. It should be mostly left alone.

[mobile.xml and browser.xml] These are your testNG.xml files. You can use these to include/exclude particular packages/classes/groups in a test run. It comes in handy, get familiar with it and utilize it often once your test suite has grown! 

### Setting up for general testing

 1. Right click on the pom.xml > Maven > Reload Project
 3. You can now add the .apk files to the project (Skip this if you want to install the app manually before testing). I recommend moving them into src/main/resources within the project.
 4. Naviage to src>main>java>com>framework>global.properties and open the file.
 5. Follow the provided instructions in the file to update the fields where needed:
    a. Project Name (Used for saving screenshots and reports to the right location) <br>
    b. IP (Your IP Address is required to initialize the drivers and interact with appium) <br>
    c. App Directory (Where the apps are located in the project)<br>
    e. Android Device (Name of the device you want to use in Android Studio uiautomatoor) <br>
    f. Android App (Name of the app you want to use for Android Automation <br>
    g. mobileBrowser (The name of the browser you want to use for Android) <br>
    
## Writing Tests

### Random Notes:

- There are 3 example tests already in the framework that you can use as an outline for writing tests
- When writing tests you will focus almost exclusively on the Test classes and the Page Objects. 
- The "Common" class also contains commonly used methods that you can utilize anywhere in your test classes. e.g. swipe
- Android's uiautomatorviewer typically does not work with the Appium server running. Stop the server before opening uiautomatorviewer
- There are many many ways to identify elements and I have chosen to specifically focus on xpath here. Explore the other methods if you feel like it!

### Test Setup

1. Utilize the existing examples as an outline. For example, the current test classes extend the Base or BrowserBase class, so your new test classes should as well. 
2. As a best practice, always include a description for your tests
3. Tests can be added to groups for organization. For example, "smoke" or "functional", by priority, by area, by login, etc. You can leverage this group assigment in the testng.xml (typically called browser.xml or mobile.xml) to run tests of a particular group only
4. Tests can be enabled and disabled as you desire
5. I recommend making an outline of your test using comments to begin. (e.g. // click on button, // get element text, //check text with assertion). You can remove the comments as you create the steps in code, or leave them for reference

### Identifying Elements

1. Use uiautomatorviewer to locate elements on the device when using an *app*. You can open it by typing 'uiautomatorviewer' into the terminal. NOTE: Make sure the appium server is off before opening the uiautomatorviewer, or it wont connect to the device. You can look up ways to use this information to create the xpath but typically it follows this format:  //android.widget.tagName[@attribute=’value’] e.g. //android.widget.textView[@id='idvalue']
2. To locate elements on the device in WebViews/Browser, use the following URL for Chrome: chrome://inspect/#devices . Other browsers typically have their own remote debugger as well. In this example, you will see devices listed and will be able to inspect them when they have an instance of chrome running. (Either a WebView or a browser itself). You can now select elements to view their xpath. [Here](https://devhints.io/xpath) is a great cheatsheet for writing xpaths.

### Test Body

1. For *Hybrid App* testing only (not browser), you must switch contexts to enter the WebView if you click on a link or button in the app that brings you to a website. If you dont switch contexts to the web view you wont be able to locate any elements or interact with the page. Once you navigate back to the app you wil need to switch back to the Native App view. You can accomplish both of these by using switchToWebContext(); and switchToNativeContext(); from the Common class
4. Any element/button/object you are interacting with in the app or browser should be contained in it's own method inside of pageObjects
5.  Tests should always begin and end from a "default" state. You want to make sure that you can run each test by itself as well as one after another. This ensures that if a test is skipped the following tests will still execute. If you cant avoid having one test being dependent on the test before it, use the "dependsOnMethods" field from TestNG. e.g. Every test starts on the app landing page and returns to it once the test is over.
6.  Utilize data providers to reduce redundant code. For example, if you perform the same set of actions on 5 different objects you can use a data provider to supply those 5 objects and loop through the code, rather than writing the same code 5 times. 
7. While assertions may not be needed for every test, they can be utilized to catch failures/defects by checking boolean statements or comparing objects to an expected value. 

## Running Tests

1. Ensure Android Studio is open
2. Open the emulator. It must be open for Appium to recognize it. If a physical device is plugged in it will likely use that over the emulator.
3. Ensure the Appium server is running
4. You should now be able to run tests. It should default to running using TestNG. <br>
   a. You can run single tests or classes by right clicking the test/class and selecting "Run" 
   b. You can run a whole suite of tests by right clicking the "mobile.xml" or "browser.xml" file and clicking "run". The testng file will executes all tests as detailed within the file. This is the best way to execute your entire suite of tests as well as particular groups, packages, classes etc. 
6. Test output will appear in the IDE as well as the Appium Server logs. 

### Test Reports

A report will be generated automatically once tests have been ran that have failed/passed. You can open it by right clicking the report > Open In > Browser > Select browser. The report is found at the following location by default:

test-output > Reports > htmlreport.html

Screenshots are not being pulled into the report at this time, but may in the future. Screenshots should still be captured upon assertion failures and should appear at test-output>Screenshots

## Contributing

Please clone the repository and create a repository specific to your project to ensure that it remains untouched. If something in the framework should be changed please create a Pull Request and assign Madison Vincent as a reviewer for approval. 

## Support

If you need any help or have any questions/concerns please reach out to Madison Vincent for help (madison.vincent@wundermanthompson.com)
