# 🧪 SwagLabs Automation Testing Framework

## 📌 Project Overview

This project is a Selenium-based automation testing framework built to test the core functionalities of [SwagLabs](https://www.saucedemo.com/) — a demo e-commerce site. It follows a **Hybrid Framework** structure combining **Page Object Model**, reusable utilities, and TestNG. It includes key scenarios like login, cart operations, checkout, and logout.

---

## 🧰 Tech Stack Used

- **Language**: Java  
- **Automation Tool**: Selenium WebDriver  
- **Test Framework**: TestNG  
- **Build Tool**: Maven  
- **Design Pattern**: Page Object Model (POM)  
- **Reporting**: TestNG Reports (can be extended to Allure)  
- **Version Control**: Git  
- **CI/CD**: Jenkins Pipeline  
- **IDE**: IntelliJ IDEA / Eclipse  

---

## 📂 Folder Structure

```
HybridFramework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/         # Page classes for each screen
│   │       ├── utils/         # Utility methods (waits, configs)
│   │       └── base/          # Base class for WebDriver setup
│   ├── test/
│       └── java/
│           └── tests/         # TestNG test classes
│
├── testng.xml                 # TestNG suite file
├── pom.xml                    # Maven dependencies and config
├── Jenkinsfile                # CI/CD Pipeline script for Jenkins
└── README.md                  # Project documentation
```

---

## ✅ Features Covered

- 🔐 Login with valid and invalid credentials  
- 🛒 Add to cart and remove items  
- 🔍 Product sorting and filtering  
- 💳 Checkout process (enter details and place order)  
- 🚪 Logout from application  
- ✅ Assertions for validations

---

## 🚀 How to Run This Project

### 1. Clone the Repository
```bash
git clone https://github.com/karunakunde/HybridFramework.git
```

### 2. Open in IDE
- Open with IntelliJ IDEA or Eclipse as a Maven Project

### 3. Run Tests
#### Option A: Using TestNG Suite
- Right-click on `testng.xml` → Run as TestNG Suite

#### Option B: Using Maven
```bash
mvn clean test
```

---

## 🔄 CI/CD Integration with Jenkins

The project uses a basic Jenkins Pipeline to automate code build and test execution.

### 📜 Jenkinsfile (Declarative Pipeline)

```groovy
pipeline {
    agent any

    stages {
        stage('Git Source Code') {
            steps {
                git 'https://github.com/karunakunde/HybridFramework.git'
            }
        }
        stage('Build Code') {
            steps {
                bat script: 'mvn compile'
            }
        }
        stage('Run Test') {
            steps {
                bat script: 'mvn clean test -Dbrowser=localchrome -X'
            }
        }
    }
}
```

> ✅ The pipeline pulls source code, compiles the project, and runs tests on Chrome browser.

⚠️ *Currently, tests are manually triggered in Jenkins — no automatic triggers added yet.*

---

## 📸 Screenshots & Reports

- Test reports are generated under `test-output` folder (TestNG default).
- Optional: You can extend the framework to capture screenshots on test failure and integrate Allure or ExtentReports.

---

## 🌐 Demo Website

🔗 [SwagLabs – Demo E-commerce site](https://www.saucedemo.com/)

---

## 👩‍💻 Author

**Karuna Kunde**  
🔗 [LinkedIn](https://www.linkedin.com/in/karuna-darekar-kunde-03a93511b/)  
📧 karunadarekarkunde@gmail.com

---

> ⭐ *Feel free to fork this repo, contribute, or use it as a reference for your own test automation learning journey!*
