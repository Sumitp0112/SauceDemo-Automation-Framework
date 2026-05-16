# SauceDemo Automation Framework

## Project Overview

This project is an automation testing framework developed for the SauceDemo application using:

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports

The framework automates major modules of the SauceDemo application including:

- Login Module
- Product Module
- Cart Module
- Checkout Module

---

## Framework Features

- Page Object Model Design
- TestNG Framework
- Maven Build Management
- Screenshot Capture on Failure
- Extent Reports
- Reusable Utility Classes
- Cross Module Test Coverage

---

## Modules Covered

### Login Module
- Valid Login
- Invalid Login
- Empty Fields Validation
- Locked User Validation
- SQL Injection Validation

### Product Module
- Product Listing
- Add to Cart
- Remove Product
- Sorting Functionality
- Logout
- Reset App State

### Cart Module
- Cart Validation
- Multiple Product Validation
- Continue Shopping
- Remove Product

### Checkout Module
- Checkout Flow
- Form Validation
- Order Confirmation
- Payment Information
- Shipping Information

---

## Tools & Technologies

| Tool | Version |
|------|---------|
| Java | 17 |
| Selenium | Latest |
| TestNG | Latest |
| Maven | Latest |
| Eclipse | IDE |

---

## Project Structure

src/main/java
    com.sauce.base
    com.sauce.pages
    com.sauce.utilities

src/test/java
    com.sauce.tests

How To Run Project
Clone Repository
git clone https://github.com/Sumitp0112/SauceDemo-Automation-Framework.git
Open Project
Open Eclipse
Import Maven Project
Run Tests

Run using:

testng.xml

Right Click:

Run As → TestNG Suite
Reports

After execution:

test-output

Contains:

ExtentReport.html
TestNG Reports
Author

Sumit Patil
