package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.BasePage;
import org.openqa.selenium.By;
import java.util.logging.Logger;

/**
 * ContactsListPage - Page Object Model for Contacts List screen
 * Contains elements and methods related to contacts list view
 */
public class ContactsListPage extends BasePage {
    
    private static final Logger logger = Logger.getLogger(ContactsListPage.class.getName());
    private static final By BACK_BUTTON = By.id("com.google.android.contacts:id/nav_back_icon");
    
    /**
     * Constructor
     * @param driver AppiumDriver instance
     */
    public ContactsListPage(AppiumDriver driver) {
        super(driver);
        logger.info("Initialized ContactsListPage");
    }
    
    /**
     * Clicks the back button to navigate back to contacts list
     */
    public void clickBackButton() {
        logger.info("Clicking back button to return to contacts list");
        click(BACK_BUTTON);
    }
    /**
     * Checks if contact exists in the list
     * @param contactName Name of the contact to verify
     * @return true if contact is found, false otherwise
     */
    public boolean isContactPresent(String contactName) {
        logger.info("Checking if contact is present: " + contactName);
        By contactLocator = By.xpath("//android.widget.TextView[@text='" + contactName + "']");
        return isElementDisplayed(contactLocator);
    }
    
    /**
     * Verifies contact is present in the list, scrolls if needed
     * @param contactName Name of the contact to verify (First Name Last Name)
     * @return true if contact found, false if not found after scrolling
     */
    public boolean verifyContactCreated(String contactName) {
        logger.info("Verifying contact was created: " + contactName);
        
        // First check if contact is visible without scrolling
        if (isContactPresent(contactName)) {
            logger.info("Contact found in list: " + contactName);
            return true;
        }
        
        // If not visible, scroll down and try again
        logger.info("Contact not visible, scrolling down...");
        scrollDown();
        
        // Check again after scrolling
        if (isContactPresent(contactName)) {
            logger.info("Contact found after scrolling: " + contactName);
            return true;
        }
        
        logger.warning("✗ Contact not found in list: " + contactName);
        return false;
    }

}

