### NOTE: Framework and README are incomplete and are in the process of being restructured

# Appium Framework

## Branching 

I recommend checking the README files for each platform branch to find platform specific information on writing and running tests: <br>
[Click here for Android](https://github.com/madison-vincent/DemoAppiumFramework/blob/androidFramework/README.md) <br>
[Click here for iOS](https://github.com/madison-vincent/DemoAppiumFramework/tree/iOSFramework#readme) <br>
[Click here for Desktop/Web](https://github.com/madison-vincent/DemoAppiumFramework/tree/webFramework#readme)

### 'Empty Frameworks' with a placeholder test: 
#### androidFramework
For testing on Android Apps, Hybrid Android Apps and Android Mobile Browsers (Chrome, Samsung Internet Browser) <br>
#### iOSFramework
For testing on iOS Apps, Hybrid iOS Apps and Mobile Safari <br>
#### webFramework
For testing on desktop browsers (Chrome, Safari, Edge, Firefox) <br>

### Example Test Frameworks with several test examples:
The following branches all contain several example tests. The tests include a variety of interactions with different kinds of applications. The tests included on each branch are listed. It may be worth checking out the web examples (even if you are automating mobile) because something about the test logic could be helpful. 

#### androidTesting <br>
Each test below includes a form of verification/assertion <br>
- Using a data provider to loop through a test <br>
- Checking for a list of buttons in a view and testing function <br>
- Swiping/Scrolling <br>
- Filling a text entry dialog <br>
- Testing a Web View on a hybrid app <br>
- Clicking and Dragging <br>
- Using an Analog Clock <br>
- Using a search bar and verifying results <br>
- Button state changes when being used (e.g. play/pause button on a video player) <br>
- Dynamically selecting elements on a calendar/date picker based on the current date <br>

#### Notes:

All tests are done on publicly available demo applications and websites created specifically for use with test automation

The Framework was made using IntelliJ on MacOS, so file path's mentioned in code may need to be adjusted.

For anyone unfamiliar with automation, I have added detailed comments to nearly every line of code. I would highly suggest going through the tests in place and reading the comments for every line to understand what their purpose is. 

## Installation

### Requirements:

1. Typical IntelliJ setup for TestNG including Java, Maven, Selenium, TestNG, Node.js (dependencies should already be in the pom.xml file) etc. <br>
    a. Currently the pom.xml file uses the following versions: Appium 7.5.1, Selenium 3.141.59, TestNG 7.4.0, Maven Surefire 3.0.0-M5 <br>
    b. If you have newer versions, update the version numbers in the pom.xml. Then right click on the pom.xml > Maven > Reload Project to load the dependencies 
2. Appium installation - I recommend the desktop client
3. XCode Installation (set up your preferred simulator)
4. Android Studio Installation (set up your preferred emulator, I recommend one that has access to the Play Store and therefore Chrome)
5. If doing testing on desktop browsers, insure they are installed. Safari will require you to allow automation within the developer menu (enabled in advanced settings)

### Creating your own repo with the code

Note: a great guide on Git exists [here](https://rogerdudler.github.io/git-guide/)

1. Create a new repository in github for your project
2. Navigate to the repository. The page should be focused on Quick Setup and the bottom section should say "...or import code from another repository". Click "Import Code"
3. Paste in https://github.com/madison-vincent/DemoAppiumFramework.git and click "Begin Import"
4. The new repository should now be a copy of the Demo framework
5. Open the IDE and create a new project based on a Verified Code Source (Get from VCS on IntelliJ). Provide the URL to your new repository
6. Switch to the repo branch you want to view/work in. Run the following command to checkout the Android Framework as an example: <br>
 git checkout androidFramework <br>
 git pull androidFramework
7. The code should be in place, as a check you can ensure that classes exist in the folder/package located at src>main>java>com>framework>base

### Setting up for general testing

 1. Right click on the pom.xml > Maven > Reload Project
 3. You can now add the .app and .apk files to the project. I recommend moving them into src/main/resources within the project.
 4. Naviage to src>main>java>com>framework>global.properties and open the file.
 5. Follow the provided instructions to update the fields where needed. Global Properties will only contain the properties relevant to the platform you are currently working. The list of customizable fields for all platforms is below: <br>
    a. Project Name (Used for saving screenshots and reports to the right location) <br>
    b. IP (Your IP Address is required to initialize the drivers and interact with appium) <br>
    c. App Directory (Where the apps are located in the project)<br>
    d. Webdriver Properties (Defining which browser you want to use for testing and the path to the driver) <br>
    e. Android Device (Name of the device you want to use in Android Studio uiautomatoor) <br>
    f. Android App (Name of the app you want to use for Android Automation <br>
    g. mobileBrowser (The name of the browser you want to use for Android) <br>
    h. iOS Device (The name of the device you want to use in Xcode XCUITest) <br>
    i. UDID (The ID of the iOS device you want to use) <br>
    j. iOS App (The name of the app that you want to use for iOS) <br>
 
### Additional set up for automation on browsers

If you plan on testing in browsers (NOT Web Views) or on dekstop browser, take the following steps: 

1. Checkout the webFramework branch
2. Locate the drivers within the project at src/main/resources
3. We need to check that we have the right drivers for the browsers we will be testing on. You should check the version of the browser you are using and then check that you are using the right driver version for that browser. Repeat this for all browsers you plan on testing with.
4. Some examples are included below, as of October/2021 I am using the following browser and driver versions: <br>
    a. "chromedriver web 93" is the chromedriver for desktop. It is currently version 93 and works with Chrome browser version 93. <br>
    b. "chromedriver 83" is the chromedriver for Android. It is currently version 83 and works with Chrome browser version 83 <br>
    c. "geckodriver 30" is the driver for Firefox on Desktop. It is currently version 30 and support Firefox Browser version 93 <br>
    d. "msedgedriver 95" is the driver for Edge on Desktop. It is currently version 95 and supports Edge browser version 95 <br>
    e. Safari does not require a driver at this time, for desktop or mobile
3. If you need to change the driver to match a newer version of your browser, simply replace the old driver with the new one. 
4. Dont forget to update the driver name in Global Properties (and location/path if it was changed)

## Usage

### Writing Tests

I recommend checking the README files for each platform branch to find platform specific information on writing and running tests: <br>
[Click here for Android](https://github.com/madison-vincent/DemoAppiumFramework/blob/androidFramework/README.md) <br>
[Click here for iOS](https://github.com/madison-vincent/DemoAppiumFramework/tree/iOSFramework#readme) <br>
[Click here for Desktop/Web](https://github.com/madison-vincent/DemoAppiumFramework/tree/webFramework#readme)

## Contributing

Please clone the repository and create a repository specific to your project to ensure that it remains untouched. If something in the framework should be changed please create a Pull Request and assign Madison Vincent as a reviewer for approval. 

## Support

If you need any help or have any questions/concerns please reach out to Madison Vincent for help (madison.vincent@wundermanthompson.com)
