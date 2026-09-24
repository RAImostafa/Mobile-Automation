package tests;

import org.example.base.BaseTest;
import org.example.pages.AddContactPage;
import org.example.pages.ContactsListPage;
import org.example.utils.TestDataReader;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * CreateContactTest
 * 
 * Test Case: Validate that a user can successfully create contact 
 * with inserting valid data in all fields and save it
 */
@Feature("Contact Management")
@Story("Create Contact")
public class CreateContactTest extends BaseTest {

    @Test(description = "Create contact with all fields")
    public void testCreateContact() {
        // Read test data from JSON
        String firstName = TestDataReader.getFirstName();
        String lastName = TestDataReader.getLastName();
        String phoneNumber = TestDataReader.getPhoneNumber();
        String email = TestDataReader.getEmail();
        String address = TestDataReader.getAddress();
        
        // Create full contact name for verification
        String fullContactName = firstName + " " + lastName;

        // Create contact page
        AddContactPage addContactPage = new AddContactPage(driver);

        // Open create contact form
        addContactPage.openCreateContactForm();

        // Fill all fields
        addContactPage.enterFirstName(firstName);
        addContactPage.enterLastName(lastName);
        addContactPage.enterPhoneNumber(phoneNumber);
        addContactPage.enterEmail(email);
        addContactPage.enterAddress(address);

        // Save contact
        addContactPage.clickSave();
        
        // Click back button to return to contacts list
        // (After saving, we land on the contact detail page first)
        ContactsListPage contactsListPage = new ContactsListPage(driver);
        contactsListPage.clickBackButton();

        // Verify contact was created and appears in the list
        SoftAssert softAssert = new SoftAssert();
        boolean isContactCreated = contactsListPage.verifyContactCreated(fullContactName);
        softAssert.assertTrue(isContactCreated, "Contact '" + fullContactName + "' should be present in the contacts list");
        softAssert.assertAll();

        System.out.println("Contact created and verified successfully: " + fullContactName);
    }

}
