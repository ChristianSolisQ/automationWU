package StepDefinitions;

import Testing.Pages.FindLocations;
import Testing.Pages.Task2Page;
import Utils.DriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2PageSteps extends DriverClass {
    private WebDriver driver;
    private Task2Page task2Page;
    private FindLocations findLocations;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Given("Navigation to https:\\/\\/www.westernunion.com\\/lt\\/en\\/home.html")
    public void navigation_to_https_www_westernunion_com_lt_en_home_html() {
        String url = "https://www.westernunion.com/lt/en/home.html";
        task2Page = new Task2Page(driver);
        task2Page.goToWesterUnionPage(url);
    }
    @When("It expands Burger menu")
    public void it_expands_burger_menu() {
        task2Page.expandHamburgerMenu();
    }
    @Then("Select Find Locations")
    public void select_find_locations() {
        task2Page.goToFindLocationsMenu();
    }

    @And("Write the zip code")
    public void write_the_zip_code() {
        String zipCode = "08247";
        findLocations = new FindLocations(driver);
        findLocations.changeToIframe();
        findLocations.writeZipCode(zipCode);
    }

    @And("Get address details of the first location printed in console")
    public void get_address_details_of_the_first_location_printed_in_console() {
      System.out.println(findLocations.getText());
    }

    @After
    public void finish() {
        driver.quit();
    }

}
