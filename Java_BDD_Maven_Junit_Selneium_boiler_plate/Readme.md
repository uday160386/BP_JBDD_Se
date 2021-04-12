# A boiler plate to create an automation tool setup.
## Java + JUnit + Selenium + Allure + Maven + Cucumber
## Features

- Download the repository and start writing feature files and step definitions
- This is just a template and customizable according to your project requirement
- Configured chrome and firefox browser, and it is extendable to other selenium supported browsers
- Integrated the allure report, so the quality of dashboard/report will be nice

## Tech

Dillinger uses a number of open source projects to work properly:

- [Maven] - build and project configuration
- [Selenium] - An open source UI automation tools
- [Cucumber-JVM]: A library to support cucumber with java
- [Allure-Report] - To generate html dashboard report
- [Junit] - Test runner
- [Java] - Programming language for writing test scripts

## Installation

This requires [Java] 8+ to run and [Maven]

Install the dependencies and devDependencies and start the server.

```sh
cd Java_BDD_Maven_Junit_Selneium_boiler_plate
mvn clean install
```

## Configure Tests
```sh
Step definitions can be saved at location: /src/test/java/org/steps/page1...
Feature files can be saved at location: /src/test/resources/org/features....
```
Note:The above paths are for reference and can be saved at your preferred path within the src/test/ folder.
## How to execute Tests?
```sh
mvn clean test -Dbrowser.type=chrome/firefox -Dbrowser.chrome.path="" browser.firefox.path=""
One need to provide the chromedriver, geckodriver path in as a input when executing it from console
Note: This approach will be changed later
```

## How to view Report?
```sh
The target folder will contain default generated reports- json/html
Using Allure:
Install allure from [Allure-Report] and execute the below command:
                 "allure serve /home/path/to/project/target/surefire-reports/"
```

## work is still in progress .....

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[Maven]: <https://maven.apache.org/>
[Cucumber-JVM]: <https://github.com/cucumber/cucumber-jvm>
[Selenium]: <https://www.selenium.dev/>
[Allure-Report]: <https://docs.qameta.io/allure/#:~:text=Allure%20Framework%20is%20a%20flexible,from%20everyday%20execution%20of%20tests.>
[Junit]: <https://junit.org/junit4/>
[Java]: <https://www.oracle.com/sg/java/technologies/javase/javase-jdk8-downloads.html>