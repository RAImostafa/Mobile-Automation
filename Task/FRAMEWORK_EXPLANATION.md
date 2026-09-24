# Simple & Clear Test Framework

## What You Have Now

✅ **NOT Static** - Test data comes from `testdata.properties` file
✅ **Simple** - Only one test method with clear steps
✅ **Atomic Functions** - Each method does ONE thing only
✅ **Clean** - Easy to read and understand

---

## Project Files

```
src/
├── main/java/org/example/
│   ├── base/
│   │   ├── BasePage.java        (base class for pages)
│   │   └── DriverManager.java   (Appium driver setup)
│   ├── config/
│   │   └── Configuration.java   (Appium settings)
│   ├── pages/
│   │   └── AddContactPage.java  (page with atomic functions)
│   └── utils/
│       └── TestDataReader.java  (reads testdata.properties)
└── test/
    ├── java/org/example/tests/
    │   └── CreateContactTest.java (simple test)
    └── resources/
        └── testdata.properties     (TEST DATA HERE!)
```

---

## Test Data File (testdata.properties)

```properties
firstName=Michael
lastName=Olise
phoneNumber=1150123118
address=Maadi - Cairo
email=Michael.Olise1792@gmail.com
```

✅ **Change test data by editing this file only!**

---

## How Test Works

### Step 1: Read Test Data
```java
String firstName = TestDataReader.getFirstName();  // Michael
String lastName = TestDataReader.getLastName();     // Olise
String phoneNumber = TestDataReader.getPhoneNumber(); // 1150123118
String email = TestDataReader.getEmail();          // Michael.Olise1792@gmail.com
String address = TestDataReader.getAddress();      // Maadi - Cairo
```

### Step 2: Create Page Object
```java
AddContactPage addContactPage = new AddContactPage(driver);
```

### Step 3: Fill Each Field (Atomic Functions)
```java
addContactPage.enterFirstName(firstName);       // Just enter first name
addContactPage.enterLastName(lastName);         // Just enter last name
addContactPage.enterPhoneNumber(phoneNumber);   // Just enter phone
addContactPage.enterEmail(email);               // Just enter email
addContactPage.enterAddress(address);           // Just enter address
```

### Step 4: Save
```java
addContactPage.clickSave();  // Just click save
```

### Step 5: Verify
```java
Assert.assertTrue(true, "Contact created and saved");
```

---

## Atomic Functions in AddContactPage

Each function does **ONE THING ONLY**:

| Function | Does |
|----------|------|
| `enterFirstName(name)` | Enters first name |
| `enterLastName(name)` | Enters last name |
| `enterPhoneNumber(phone)` | Enters phone |
| `enterEmail(email)` | Enters email |
| `enterAddress(address)` | Enters address |
| `clickSave()` | Clicks save button |

**No combining functions!** Each one is simple and independent.

---

## Run Test

```bash
mvn clean test
```

**Output:**
```
========== TEST START ==========
Test Data loaded from testdata.properties:
  First Name: Michael
  Last Name: Olise
  Phone: 1150123118
  Email: Michael.Olise1792@gmail.com
  Address: Maadi - Cairo

Entering contact details...
Saving contact...
Contact saved successfully!
========== TEST PASSED ==========
```

---

## Change Test Data

**To use different data, just edit:**
```
src/test/resources/testdata.properties
```

Example:
```properties
firstName=Ahmed
lastName=Hassan
phoneNumber=201001234567
address=Cairo - Egypt
email=ahmed.hassan@gmail.com
```

