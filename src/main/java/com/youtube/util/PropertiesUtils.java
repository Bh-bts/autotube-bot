package com.youtube.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for managing properties loaded from a configuration file.
 *
 * @author Bhavin.Thumar
 */
public class PropertiesUtils {

    // Path to the configuration file
    private static final String CONFIG_FILE_PATH = "/src/test/resources/config/config.properties";

    // Keys for different properties in the configuration file
    private static final String HEADLESS_KEY = "headless";
    private static final String TAB_KEY = "tab";
    private static final String URL_KEY = "url";
    private static final String CHANNEL_KEY = "channel";

    private static Properties prop;

    /**
     * Load properties from the configuration file.
     *
     * @return The loaded Properties object.
     */
    private static Properties loadProperties() {
        if (prop == null) {
            String projectPath = System.getProperty("user.dir");
            prop = new Properties();

            try (FileReader reader = new FileReader(projectPath + CONFIG_FILE_PATH)) {
                prop.load(reader);
            } catch (IOException e) {
                throw new RuntimeException("Error loading properties file", e);
            }
        }
        return prop;
    }

    /**
     * Get the headless mode property.
     *
     * @return The headless mode value as a boolean.
     * @throws IOException if an I/O error occurs.
     */
    public static boolean getHeadlessMode() {
        String headlessValue = getProperty(HEADLESS_KEY);
        return Boolean.parseBoolean(headlessValue);
    }

    /**
     * Get the tab property.
     *
     * @return The tab value.
     * @throws IOException if an I/O error occurs.
     */
    public static String getTab() {
        return getProperty(TAB_KEY);
    }

    /**
     * Get the URL property.
     *
     * @return The URL value.
     * @throws IOException if an I/O error occurs.
     */
    public static String getURL() {
        return getProperty(URL_KEY);
    }

    /**
     * Get the channel property.
     *
     * @return The channel value.
     * @throws IOException if an I/O error occurs.
     */
    public static String getChannel() {
        return getProperty(CHANNEL_KEY);
    }

    /**
     * Get the property value associated with the given key.
     *
     * @param key The key of the property.
     * @return The value associated with the key.
     */
    private static String getProperty(String key) {
        return loadProperties().getProperty(key);
    }
}
