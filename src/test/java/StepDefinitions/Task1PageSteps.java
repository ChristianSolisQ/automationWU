package StepDefinitions;

import Testing.Pages.Task1Page;
import Utils.DriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;



public class Task1PageSteps extends DriverClass {

    private WebDriver driver;
    private Task1Page task1Page;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }




    @Given("Navigate to https:\\/\\/www.westernunion.com\\/lt\\/en\\/home.html")
    public void navigate_to_https_www_westernunion_com_lt_en_home_html() {
        String url = "https://www.westernunion.com/lt/en/home.html";
        task1Page = new Task1Page(driver);
        task1Page.goToWesterUnionPage(url);
    }

    @When("Expand Burger menu")
    public void expand_burger_menu() {
        task1Page.expandHamburgerMenu();
    }

    @Then("Select settings page")
    public void select_settings_page() {
        task1Page.goToSettingsMenu();
    }

    @And("Change WU.com Country to United States")
    public void change_wu_com_country_to_united_states() {
        String value = "United States";
       task1Page.changeCountry(value);
    }

    @And("Assert that correct country page was loaded.")
    public void assert_that_correct_country_page_was_loaded() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue("The url is in United States", url.equals("https://www.westernunion.com/us/en/home.html"));
        if(url.equals("https://www.westernunion.com/us/en/home.html")){
            System.out.println("The url is in United States");
        }else{
            System.err.println("The url is not in United States");
        }
    }
    @After
    public void finish() {
        driver.quit();
    }
}
