# HybridFramework 🚀

## 📌 Overview
HybridFramework is a **Java-based automation testing framework** designed to combine the strengths of multiple testing approaches (Data-Driven + Keyword-Driven + Modular).  
It provides a scalable, maintainable, and reusable structure for automated test execution.

---

## 🛠 Tech Stack
- **Language:** Java (64%)
- **Frontend/Reports:** HTML (35.3%), CSS (0.7%)
- **Build Tool:** Apache Maven
- **Testing Framework:** TestNG
- **Logging:** Log4j2
- **CI/CD:** Jenkins Pipeline
- **Browser Driver:** ChromeDriver (v138)

---

## 📂 Project Structure
HybridFramework/
│── src/                # Source code
│── test-output/        # TestNG reports
│── pom.xml             # Maven dependencies
│── testng.xml          # Test suite configuration
│── Jenkinsfile         # CI/CD pipeline
│── .gitignore          # Ignored files
│── .classpath/.project # Eclipse project files

---

## ⚙️ Features
- Modular test case design for reusability
- Data-driven testing with TestNG
- Centralized logging using Log4j2
- Maven-based dependency management
- Jenkins pipeline integration for CI/CD
- HTML-based test execution reports

---

## 🚀 Getting Started
### Prerequisites
- Java JDK 8+
- Maven 3+
- ChromeDriver (v138 or compatible)
- IDE (Eclipse/IntelliJ)

### Installation
```bash
# Clone the repository
git clone https://github.com/karunakunde/HybridFramework.git

# Navigate to project directory
cd HybridFramework

# Run tests with Maven
mvn clean test

