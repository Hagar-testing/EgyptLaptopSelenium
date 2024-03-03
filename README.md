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
* Have a supporting Utils package in *src/test/java* file path, named ***"Utils"*** 

### How to run the project main test cases locally:
* A properties file ***"prod.properties"*** can be found in *config* package including all the configurations needed in the execution
* Can find the test cases in the *src/test/java* folder mainly in the *testcases* package
* Can find the test suite for all the main practice test cases in the *testing.xml* file
* To start the execution, right click on the testing.xml file and click run
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `allure serve allure-results` (needs to be able to execute mvn commands); Or you can find the Extent Report ***ExtentReports.html*** in the reports package in the project root path for the latest execution

### Running test cases on Chrome ###
https://github.com/Hagar-testing/EgyptLaptopSelenium/assets/138511085/9a2fc3cf-6889-4c8a-ad81-ee7aca9f9234

### Running test cases on Edge ###
https://github.com/Hagar-testing/EgyptLaptopSelenium/assets/138511085/8ff13474-9ef8-4154-a781-b498a4fa6a28

### Allure Report ##
<img width="958" alt="Allure report" src="https://github.com/Hagar-testing/EgyptLaptopSelenium/assets/138511085/f95e420a-8e94-48bb-b590-3f7b80757e80">

### Extent Report ##
<img width="954" alt="Extent Report" src="https://github.com/Hagar-testing/EgyptLaptopSelenium/assets/138511085/8bb10bd5-076f-43e2-8479-d03e14b91fa4">

