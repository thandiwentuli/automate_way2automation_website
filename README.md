# automate_way2automation_website

Website Link: "https://www.way2automation.com/angularjs-protractor/banking/#/login"



# Cucumber-JVM 

This README provides instructions on how to use and run the tests in our project, along with a list of tools utilized in creating the testing framework.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Tools Used](#tools-used)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Our test framework is designed to ensure the reliability and functionality of our application through automated testing. This README serves as a guide for users and developers to effectively utilize and contribute to our testing efforts.

## Prerequisites

Before running the tests, ensure that the following prerequisites are met:
- intelliJ IDEA
- 

- [List any prerequisites here, e.g., programming language installed, testing framework dependencies, etc.]

## Installation

To set up the testing environment:

1. Clone the repository to your local machine. path: https://github.com/thandiwentuli/automate_way2automation_website.git
2. Install any dependencies required for the testing framework.
3. Configure any necessary settings or configurations for running the tests.

## Running Tests

To run the tests:

1. Navigate to the directory containing the TestRunner.
2. Execute the Test Using the Runner
3. Monitor the test execution for any failures or errors.
4. Review the test reports or logs generated to identify any issues.

## Tools Used

Our testing framework utilizes the following tools:

- **[Testing Framework]**: [Cucumber-JVM , ]
- **[Automation Tool]**: [WebDriver]
- **[Reporting Tool]**: [ExtentReports]
- **[Other Tools]**: [L?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>CombinedGroupCucumber</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.17.0</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>7.17.0</version>
        </dependency>

        <!--    <dependency>-->
        <!--        <groupId>io.cucumber</groupId>-->
        <!--        <artifactId>cucumber-junit</artifactId>-->
        <!--        <version>7.17.0</version>-->
        <!--        <scope>test</scope>-->
        <!--    </dependency>-->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.20.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.8.0</version>
        </dependency>
        <dependency>
            <groupId>tech.grasshopper</groupId>
            <artifactId>extentreports-cucumber7-adapter</artifactId>
            <version>1.14.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <includes>
                        <include>Runners.runner</include>
                    </includes>
                </configuration>
            </plugin>
        </plugins>
    </build>


</project>]

## Contributing

We welcome contributions to enhance our testing framework. If you'd like to contribute, please follow these guidelines:

- Fork the repository and create a new branch for your feature or improvement.
- Ensure that your code adheres to our coding standards and practices.
- Submit a pull request detailing the changes you've made and the problem it solves.

## License

