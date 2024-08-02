package openSite;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

// Certifies that the test class is correctly configured to run with Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class OpenSiteTest {
    WebDriver driver;
    String URL;
    String currentUrl;


    @BeforeAll
    public void init() {
        System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver.exe"); // Chrome driver located in this repository (v. 126.0.6478.182)
        driver = new ChromeDriver();
    }

    @After
    public void finish() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("user has access to site url")
    public void user_has_access_to_site_url() {
        URL = "https://automationexercise.com";

        // Initializing chrome for testing and chrome driver
        System.out.println("URL available");
    }
    @When("search site url")
    public void search_site_url() {
        driver.get(URL);
    }
    @Then("displays expected page")
    public void displays_expected_page() {
        currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(URL));
    }
}