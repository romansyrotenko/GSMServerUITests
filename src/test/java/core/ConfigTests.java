package core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigTests {

    public static int IMPLICITY_WAIT_TIME;
    public static int FLUENT_WAIT_TIMEOUT;
    public static int FLUENT_WAIT_POLLING;
    public static String BASE_URL;
    public static String CART_PAGE_URL;
    public static String PRODUCT_PAGE_URL;
    public static String SEARCH_PRODUCT_NAME;

    public void loadProperties() throws IOException {
        Properties properties = new Properties();
        File resourcesDirectory = new File("src/main/resources/config.properties");
        File file = new File(resourcesDirectory.getAbsolutePath());
        properties.load(new FileReader(file));

        this.IMPLICITY_WAIT_TIME = Integer.parseInt(properties.getProperty("IMPLICITY_WAIT_TIME"));
        this.FLUENT_WAIT_TIMEOUT = Integer.parseInt(properties.getProperty("FLUENT_WAIT_TIMEOUT"));
        this.FLUENT_WAIT_POLLING = Integer.parseInt(properties.getProperty("FLUENT_WAIT_POLLING"));
        this.BASE_URL = properties.getProperty("BASE_URL");
        this.CART_PAGE_URL = properties.getProperty("CART_PAGE_URL");
        this.PRODUCT_PAGE_URL = properties.getProperty("PRODUCT_PAGE_URL");
        this.SEARCH_PRODUCT_NAME = properties.getProperty("SEARCH_PRODUCT_NAME");

    }

}
