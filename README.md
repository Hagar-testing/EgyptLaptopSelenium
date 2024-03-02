# Egypt-Laptops-Selenium

### The main Frameworks included in the project:
* Selenium Webdriver
* TestNG
* Allure Report
* Extent Reports

### Project Design:
* Page Object Model (POM) design pattern
* Data Driven framework
* Fluent design approach (method chaining)
* Have a supporting Utils package in *src/test/java* file path, named ***"Utils"*** that includes many wrapper methods in static classes which services as a core engine for the project 

### How to run the project main test cases locally:
* A properties file ***"automationPractice.properties"*** can be found it *src/main/resources* file path including all the configurations needed in the execution
* Can find the test cases in the *src/test/java* folder mainly in the *testcases* package
* Can find the test suite for all the main practice test cases in the *testing.xml* file
* To start the execution, right click on the testing.xml file and click run
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `allure serve allure-results` (needs to be able to execute mvn commands); Or you can find the Extent Report ***ExtentReports.html*** in the reports package in the project root path for the latest execution


