package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.BasePage;
import org.openqa.selenium.By;

/**
 * AddContactPage - Page Object for adding new contact
 * Locators are based on actual Android Contacts app UI
 */
public class AddContactPage extends BasePage {

    private static final By ADD_CONTACT_BUTTON = By.id("com.google.android.contacts:id/floating_action_button");

    // Form fields - using content-desc and text attributes
    private static final By FIRST_NAME_FIELD = By.xpath("//android.widget.EditText[@content-desc='First name']");
    private static final By LAST_NAME_FIELD = By.xpath("//android.widget.EditText[@content-desc='Last name']");
    private static final By PHONE_FIELD = By.xpath("//android.widget.EditText[contains(@text, '+')]");
    private static final By EMAIL_FIELD = By.xpath("//android.widget.EditText[.//android.widget.TextView[@text='Email']]");
    private static final By ADDRESS_FIELD = By.xpath("//android.widget.EditText[.//android.widget.TextView[@text='Address']]");


    // Buttons
    private static final By SAVE_BUTTON = By.xpath("//android.widget.TextView[@text='Save']/parent::android.view.View");
    private static final By EMAIL_BUTTON = By.xpath("//android.widget.TextView[@text='Email']/parent::android.view.View");
    private static final By ADDRESS_BUTTON = By.xpath("//android.widget.TextView[@text='Address']/parent::android.view.View");

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
        click(EMAIL_BUTTON);
        waitForElementVisibility(EMAIL_FIELD);
        click(EMAIL_FIELD);
        sendText(EMAIL_FIELD, email);
        hideKeyboard();
        scrollDown();
    }

    public void enterAddress(String address) {
        scrollDown();
        waitForElementClickability(ADDRESS_BUTTON);
        click(ADDRESS_BUTTON);
        waitForElementVisibility(ADDRESS_FIELD);
        click(ADDRESS_FIELD);
        sendText(ADDRESS_FIELD, address);
    }


    public void clickSave() {
        click(SAVE_BUTTON);
    }

}

