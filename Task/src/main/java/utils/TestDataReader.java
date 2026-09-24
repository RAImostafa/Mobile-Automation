package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

/**
 * TestDataReader - Reads test data from JSON file
 */
public class TestDataReader {
    private static JsonObject testData;

    static {
        try {
            JsonParser parser = new JsonParser();
            testData = parser.parse(new FileReader("src/test/resources/testdata/contact-data.json")).getAsJsonObject();
        } catch (IOException e) {
            System.err.println("Error loading test data: " + e.getMessage());
        }
    }

    public static String getFirstName() {
        return testData.get("firstName").getAsString();
    }

    public static String getLastName() {
        return testData.get("lastName").getAsString();
    }

    public static String getPhoneNumber() {
        return testData.get("phoneNumber").getAsString();
    }

    public static String getEmail() {
        return testData.get("email").getAsString();
    }

    public static String getAddress() {
        return testData.get("address").getAsString();
    }
}

