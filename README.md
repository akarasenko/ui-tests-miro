# UI tests for 

# INFO
The project contains UI tests for registration on https://miro.com/signup/.

# SETUP
1. Open the project in IDE
2. Install Gradle https://gradle.org/install/
3. Open build.gradle and reload all Gradle project
4. Download chromedriver.exe https://chromedriver.chromium.org/downloads and put it into the project directory or add its path to Path variable
5. Download Allure framework https://github.com/allure-framework/allure2/releases and put it into the project directory or add its path to Path variable

# RUN TESTS
1. Be sure that folders /allure-results, /screenshots are empty for each build
2. Run tests by running console command 'gradlew clean test'.
After tests are completed folder /allure-results is generated with run results.
If a test fails a page screenshot is done and saved in / screenshot folder
3. Generate Allure report by running console command 'allure generate allure-results --clean -o allure-report'.
A generated report is saved in /allure-report folder.
4. To open Allure report run console command 'allure serve allure-results'

You can also run each test in IDE by clicking on green run button near each test method or test class.

# STRUCTURE DESCRIPTION
Test are based on Java + Gradle + Selenium WebDriver + TestNG + Allure reports.
Tests can be run in Google Chrome browser.
Page object pattern is used for the project.
All tests can be found in /src/test/java/tests.
All pages classes can be found in /src/test/java/pages.
testng.xml configuration is used to set parameters for tests. .xml file for each test can be found in /parametersXml.
local.properties is used to set up common for all tests parameters as page URL.

# HOW I GENERATE TEST
Some fields validation e.g. password field are quite complicated, so firstly I would ask for requirements and talk to analyst/business expert/developer/etc to understand better user story and data inputs.
Exploratory testing method is used to create this tests.

# SOME TEST RESULTS
During performing tests it was mentioned that the front validation on spot sometimes doesn't work for Password field (flaky tests show this).
E.g., if a user types "qwe@qwe" in Password field the error hint "The email you entered is incorrect." is not shown after focus is out the field althogh POST /validation returns 400 with body like "...{message: "Email is not valid"}...". The hint for field is only shown when a user clicks submit button and a server validates user data.
Please check if this is should be fixed or its just expected behavior.