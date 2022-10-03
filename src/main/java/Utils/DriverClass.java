package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
    /**
    *The Driver
     **/
    public static WebDriver driver;

    /**
     * Get driver web driver
     *
     * @return the web driver
     */
    public WebDriver getDriver(){
        return driver;
    }

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
