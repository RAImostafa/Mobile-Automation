package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * AddContactPage - Page Object for adding new contact
 * Locators are based on actual Android Contacts app UI hierarchy
 */
public class AddContactPage extends BasePage {

    private static final By ADD_CONTACT_BUTTON = By.id("com.google.android.contacts:id/floating_action_button");

    // Form fields - using content-desc and text attributes
    private static final By FIRST_NAME_FIELD = By.xpath("//android.widget.EditText[@content-desc='First name']");
    private static final By LAST_NAME_FIELD = By.xpath("//android.widget.EditText[@content-desc='Last name']");
    private static final By PHONE_FIELD = By.xpath("//android.widget.EditText[contains(@text, '+')]");
    private static final By EMAIL_FIELD = By.xpath("//android.widget.EditText//android.widget.TextView[@text='Email (Home)']/ancestor::android.widget.EditText");
    private static final By ADDRESS_FIELD = By.xpath("//android.widget.EditText//android.widget.TextView[@text='Address']/ancestor::android.widget.EditText");
    private static final By NOTES_FIELD = By.xpath("//android.widget.EditText//android.widget.TextView[@text='Notes']/ancestor::android.widget.EditText");
    
    // Buttons
    private static final By SAVE_BUTTON = By.xpath("//android.widget.TextView[@text='Save']/parent::android.view.View");
    private static final By ADD_PHONE_BUTTON = By.xpath("//android.widget.TextView[@text='Add phone']/parent::android.view.View");
    private static final By ADD_EMAIL_BUTTON = By.xpath("//android.widget.TextView[@text='Add email']/parent::android.view.View");
    private static final By ADD_ADDRESS_BUTTON = By.xpath("//android.widget.TextView[@text='Add address']/parent::android.view.View");

    public AddContactPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickAddContactButton() {
        click(ADD_CONTACT_BUTTON);
    }

    public void openCreateContactForm() {
        clickAddContactButton();
        findElement(FIRST_NAME_FIELD);
    }

    public void enterFirstName(String firstName) {
        sendText(FIRST_NAME_FIELD, firstName);
    }

    public void enterLastName(String lastName) {
        sendText(LAST_NAME_FIELD, lastName);
    }

    public void enterPhoneNumber(String phoneNumber) {
        sendText(PHONE_FIELD, phoneNumber);
    }

    public void enterEmail(String email) {
        scrollDown();
        sendText(EMAIL_FIELD, email);
    }

    public void enterAddress(String address) {
        sendText(ADDRESS_FIELD, address);
    }

    public void enterNotes(String notes) {
        sendText(NOTES_FIELD, notes);
    }

    public void clickSave() {
        click(SAVE_BUTTON);
    }

    public void clickAddEmailButton() {
        click(ADD_EMAIL_BUTTON);
    }

    public void clickAddAddressButton() {
        click(ADD_ADDRESS_BUTTON);
    }
}

