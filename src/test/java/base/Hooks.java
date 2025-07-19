package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

import java.time.Duration;

/**
 * Cucumber Hooks zur Steuerung des WebDriver-Lebenszyklus und Screenshots. Diese Klasse wird von Cucumber vor und nach jedem Szenario ausgeführt.
 */
public class Hooks {
    private WebDriver driver;
    private HomePage homePage;

    // Gibt die initialisierte HomePage-Instanz zurück, um sie in Step Definitions zu teilen.
    public HomePage getHomePage() {
        return homePage;
    }

    // Wird vor jedem Cucumber-Szenario ausgeführt. Initialisiert den Browser und navigiert zur Startseite.
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get(TestSetup.BASE_URL);

        homePage = new HomePage(driver);
    }

    // Wird nach jedem Cucumber-Szenario ausgeführt. Schließt den Browser und macht Screenshots bei Fehlern.
    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName() + "_failure_screenshot");
            }
            driver.quit();
        }
    }
}