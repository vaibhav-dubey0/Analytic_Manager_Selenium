# Analytic_Manager_Selenium
│
├── src/main/java
│   ├── base           → Common setup/teardown
│   ├── locators       → Page locators
│   ├── pages          → Page Object classes
│   ├── utils          → Helpers (waits, config, excel, etc.)
│   ├── reports        → Extent report setup
│   └── datadriven     → Data providers / test data handling
│
├── src/main/resources → Config files, log4j, etc.
│
├── src/test/java
│   ├── tests          → TestNG test cases
│   ├── listeners      → TestNG listeners (extent, screenshots)
│   └── flaky          → Retry analyzers, flaky test handlers
│
├── reports            → Generated HTML reports
├── target             → Build output
├── pom.xml            → Maven dependencies
└── testng.xml         → Test suite definition


1. Project Overview

“This is a Selenium Test Automation Framework built using Java, TestNG, and Maven. It follows Page Object Model (POM) design with utilities for reporting, waits, listeners, and flaky test handling.”

2. Tech Stack

Java (JDK 21)

Selenium WebDriver

TestNG

Maven

ExtentReports
