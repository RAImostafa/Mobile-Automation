package org.example.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.config.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static AppiumDriver driver;
    
    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }
    
    private static void initializeDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAppPackage(Configuration.APP_PACKAGE);
        options.setAppActivity(Configuration.APP_ACTIVITY);
        options.setPlatformName(Configuration.PLATFORM_NAME);
        options.setDeviceName(Configuration.DEVICE_NAME);
        options.setPlatformVersion(Configuration.PLATFORM_VERSION);
        options.setAutoGrantPermissions(true);
        options.setNoReset(true);
        options.setNewCommandTimeout(Duration.ofSeconds(300));
        
        driver = new AndroidDriver(
            new URL(Configuration.APPIUM_SERVER_URL),
            options
        );
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

