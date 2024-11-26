package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected static WebDriver driver;
    public static String DIR_PATH;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
            DIR_PATH = properties.getProperty("DIR_PATH");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load DIR_PATH from config.properties");
        }
    }

    public static WebDriver startDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        return driver;
    }

    public static WebDriver getDriver(){
        if(driver == null){
            driver = startDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
