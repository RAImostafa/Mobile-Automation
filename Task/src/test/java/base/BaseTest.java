package org.example.base;

import org.example.base.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;

/**
 * BaseTest - Base class for all tests
 */
public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

