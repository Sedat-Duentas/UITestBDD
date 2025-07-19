package pages;

import org.openqa.selenium.WebDriver;
import static locators.HomePageLocators.*;
import static utils.WaitUtils.waitForElementClickable;
import static utils.WaitUtils.waitForElementVisible;

/**
 * Page Object Klasse für die Startseite (HomePage). Kapselt alle Aktionen, die auf der Startseite möglich sind.
 */
public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigiert zur Registrierungs-Seite und gibt eine neue Instanz der RegisterPage.
    public RegisterPage goToRegisterPage() {
        waitForElementClickable(driver, REGISTER_LINK).click();
        return new RegisterPage(driver);
    }

    // Prüft, ob der Benutzer eingeloggt ist, indem der Account-Link im Header geprüft wird.
    public boolean isUserLoggedIn() {
        try {
            return waitForElementVisible(driver, LOGGED_IN_ACCOUNT_LINK).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Führt einen Logout durch und gibt eine neue Instanz der HomePage. Dabei versucht es sich auszuloggen, wenn der Benutzer tatsächlich eingeloggt ist
    public HomePage logout() {
        if (isUserLoggedIn()) {
            waitForElementClickable(driver, LOGOUT_LINK).click();
        } else {
            System.out.println("WARNUNG: Logout wurde versucht, obwohl der Benutzer nicht eingeloggt war.");
        }
        return new HomePage(driver);
    }
}