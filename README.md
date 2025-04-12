This repo contains test cases for testing HTML pages, elements and navigations using [Selenium](https://www.selenium.dev/) with Java binding and [TestNG](https://testng.org/).

This example is using a local HTML document with various elements and styled with CSS and JavaScript.

### Getting started with Selenium 
1. Install Java Development Kit
2. Install an Integrated Development Environment (IDE): this example was created in IntelliJ IDEA
3. Create a new Java project in your IDE and select the build system: this project is using Maven
4. Add Selenium and TestNG dependencies into `pom.xml` file
5. Start creating your test classes and Page Object Model (POM) classes

### About TestNG Annotations
TestNG is a popular Java testing framework that makes it easier to write, organize, and run automated tests.
TestNG annotations are special markers in Java code that control how your tests and suites are executed:
- `@Test` marks a method as a test
- `@BeforeSuite` and `@AfterSuite` annotate methods that will be executed once at the beginning and the end of a test suite
- `@BeforeTest` and `@AfterTest` mark methods that will be executed before and after running all tests within a class
More examples and explanations can be found [here](https://testng.org/annotations.html)


### How to work with different UI elements



### Few words about Page Object Model (POM)



### Execution and results

![img.png](img.png)