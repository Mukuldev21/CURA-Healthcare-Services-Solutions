<div align="center">
  
# CURA-Healthcare-Services-Solutions

  <img src="https://raw.githubusercontent.com/Mukuldev21/CURA-Healthcare-Services-Solutions/main/src/test/resources/images/cura-logo.png" alt="CURA Logo" width="400">
</div>

## 🌟 Overview

This repository contains an end-to-end test automation framework for the CURA Healthcare Services web application. It demonstrates a robust implementation of modern test automation practices using industry-standard tools and technologies.

The framework follows Page Object Model design pattern and includes comprehensive test coverage for all critical functionalities of the CURA Healthcare application.

## 🛠️ Technologies & Tools

<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" alt="Java" width="70" height="70"/>
        <br><b>Java 21</b>
      </td>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/selenium/selenium-original.svg" alt="Selenium" width="70" height="70"/>
        <br><b>Selenium WebDriver</b>
      </td>
      <td align="center">
        <img src="https://avatars.githubusercontent.com/u/12528662" alt="TestNG" width="70" height="70"/>
        <br><b>TestNG</b>
      </td>
      <td align="center">
        <img src="https://www.extentreports.com/wp-content/uploads/2018/09/Extent_logomark_transparentbg.png" alt="Extent Reports" width="70" height="70"/>
        <br><b>Extent Reports</b>
      </td>
    </tr>
    <tr>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/json/json-original.svg" alt="JSON" width="70" height="70"/>
        <br><b>JSON</b>
      </td>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original-wordmark.svg" alt="Git" width="70" height="70"/>
        <br><b>Git</b>
      </td>
      <td align="center">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" alt="Maven" width="70" height="70"/>
        <br><b>Maven</b>
      </td>
    </tr>
  </table>
</div>

## ✨ Key Features

- **Page Object Model**: Implements a clean separation between test code and page-specific code
- **Data-Driven Testing**: Uses JSON files for test data management
- **Comprehensive Reporting**: Integrated Extent Reports for detailed visual test reports
- **Cross-Browser Testing**: Supports multiple browsers for maximum coverage
- **Screenshot Capture**: Automatic screenshot capture on test failure
- **Parallel Execution**: Configured for parallel test execution to reduce runtime
- **CI/CD Ready**: Compatible with continuous integration pipelines

## 📊 Test Cases & Results

| Test Case | Status |
|-----------|--------|
| Verify Homepage Accessibility | ✅ Passed |
| Verify Login Functionality | ✅ Passed |
| Verify Login with Invalid Credentials | ✅ Passed |
| Verify Appointment Booking | ✅ Passed |
| Verify Appointment Booking Without Required Fields | ✅ Passed |
| Verify Appointment History | ✅ Passed |
| Verify Logout Functionality | ✅ Passed |
| Verify Navigation to Homepage | ✅ Passed |

## 🚀 Project Structure

```
CURA-Healthcare-Services-Solutions/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── curahealthcare/
│   │               ├── base/         # Base test setup and config
│   │               ├── pages/        # Page Object classes
│   │               ├── utils/        # Utility classes and helpers
│   │               └── listeners/    # TestNG listeners
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── curahealthcare/
│       │           └── tests/        # Test classes
│       └── resources/
│           ├── testdata/             # JSON test data files
│           ├── config/               # Configuration properties
│           └── drivers/              # WebDriver executables
├── test-output/                      # Test execution reports
├── pom.xml                           # Maven dependencies
└── README.md                         # Project documentation
```

## 🔄 Getting Started

### Prerequisites

- Java JDK 21
- Maven
- Chrome/Firefox/Edge browser
- Git

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/Mukuldev21/CURA-Healthcare-Services-Solutions.git
   ```

2. Navigate to the project directory:
   ```bash
   cd CURA-Healthcare-Services-Solutions
   ```

3. Install dependencies:
   ```bash
   mvn clean install
   ```

4. Run the tests:
   ```bash
   mvn test
   ```

## 📈 Reports

After test execution, detailed Extent Reports are generated in the `test-output` directory. These reports include:

- Test execution summary
- Step-by-step test logs
- Screenshots of failures
- Environment details
- Execution metrics

## 🔍 CI/CD Integration

This framework is designed to work seamlessly with CI/CD pipelines like Jenkins, GitHub Actions, or Azure DevOps.

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/Mukuldev21/CURA-Healthcare-Services-Solutions/issues).

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Contact

Mukul Dev - [@LinkedIn](https://www.linkedin.com/in/mukuldev21/)

Project Link: [https://github.com/Mukuldev21/CURA-Healthcare-Services-Solutions](https://github.com/Mukuldev21/CURA-Healthcare-Services-Solutions)
