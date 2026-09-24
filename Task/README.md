# Android Contacts Test Automation

Simple test automation for adding a new contact in Android Contacts app using Appium and TestNG.

## Key Feature
✅ **Dynamic Test Data** - Test data is read from `testdata.properties` file (NOT hardcoded)

## Prerequisites

- Java JDK 11+
- Maven 3.6+
- Appium Server running on http://127.0.0.1:4723
- Android device or emulator with USB debugging enabled
- Android Contacts app installed

## Setup

### 1. Install Dependencies
```bash
mvn clean install
```

### 2. Start Appium Server
```bash
appium
```

### 3. Configure Test Data
Edit `src/test/resources/testdata.properties`:
```properties
firstName=Michael
lastName=Olise
phoneNumber=1150123118
address=Maadi - Cairo
email=Michael.Olise1792@gmail.com
```

### 4. Configure Device (Optional)
Edit `src/main/java/org/example/config/Configuration.java`:
```java
public static final String DEVICE_NAME = "emulator-5554"; // Your device name
public static final String PLATFORM_VERSION = "11"; // Your Android version
```

## Run Tests

```bash
# Run all tests
mvn clean test

# Run specific test
mvn clean test -Dtest=CreateContactTest
```

## Project Structure

```
src/
├── main/java/org/example/
│   ├── base/              # BasePage and DriverManager
│   ├── config/            # Configuration
│   ├── pages/             # AddContactPage (Page Object Model)
│   └── utils/             # TestDataReader (reads from properties)
└── test/
    ├── java/org/example/tests/  # Test classes
    └── resources/
        └── testdata.properties  # Test data file (EDIT THIS!)
```

## How It Works

1. **Test Data in File** - All test data is stored in `testdata.properties`
2. **TestDataReader** - Utility class reads data from the properties file
3. **Atomic Functions** - Each method in AddContactPage does one thing only
4. **Simple Test** - Test class is clean and easy to read

## Test Execution Flow

```
1. Load test data from testdata.properties
2. Print test data to console
3. Create AddContactPage object
4. Fill each field one by one (atomic functions)
5. Click Save button
6. Verify success
```

## Edit Test Data

Open `src/test/resources/testdata.properties` and change values:

```properties
firstName=Michael
lastName=Olise
phoneNumber=1150123118
address=Maadi - Cairo
email=Michael.Olise1792@gmail.com
```

## Framework

- **Appium 8.6.0:** Mobile test automation
- **TestNG 7.8.1:** Test execution framework
- **Atomic Functions:** Each method does one thing

## Troubleshooting

**Device not found:**
```bash
adb devices
adb kill-server && adb start-server
```

**Appium connection error:**
Check if Appium server is running on http://127.0.0.1:4723

**Properties file not found:**
Make sure `testdata.properties` exists in `src/test/resources/` folder



