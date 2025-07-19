package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import utils.TestUser;

import static locators.RegisterPageLocators.*;
import static utils.WaitUtils.waitForElementClickable;
import static utils.WaitUtils.waitForElementVisible;

/**
 * Page Object Klasse für die Registrierungsseite. Beinhaltet das Ausfüllen des Formulars, Abschicken und die Erfolgsprüfung.
 */

public class RegisterPage {
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Füllt das Registrierungsformular mit den Angaben des TestUsers.
    public void fillRegistrationForm(TestUser user) {
        waitForElementClickable(driver, GENDER_MALE).click();
        waitForElementVisible(driver, FIRST_NAME_INPUT).sendKeys(user.firstName);
        waitForElementVisible(driver, LAST_NAME_INPUT).sendKeys(user.lastName);
        waitForElementVisible(driver, EMAIL_INPUT).sendKeys(user.email);
        waitForElementVisible(driver, PASSWORD_INPUT).sendKeys(user.password);
        waitForElementVisible(driver, CONFIRM_PASSWORD_INPUT).sendKeys(user.password);
    }

    // Klickt auf den Registrieren-Button und wartet, bis die Erfolgsmeldung sichtbar ist.
    public void clickRegisterButton() {
        waitForElementClickable(driver, REGISTER_BUTTON).click();
    }

    // Prüft, ob die Registrierung erfolgreich war, basierend auf dem Erfolgstext.
    public boolean isRegistrationSuccessful() {
        try {
            WebElement result = waitForElementVisible(driver, REGISTRATION_SUCCESS_MESSAGE);
            return result.getText().contains("Your registration completed");
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Klickt auf den "Continue"-Button und gibt eine Instanz der HomePage zurück.
    public HomePage clickContinueButton() {
        waitForElementClickable(driver, CONTINUE_BUTTON).click();
        return new HomePage(driver);
    }

    // Ruft die Fehlermeldung ab, die nach einem fehlgeschlagenen Registrierungsversuch angezeigt wird.
    public String getRegistrationErrorMessage() {
        try {
            // Versucht, die Fehlermeldung zu finden und ihren Text zu holen. Wenn sie nicht sichtbar wird, fängt es die TimeoutException ab.
            return waitForElementVisible(driver, REGISTRATION_ERROR_MESSAGE).getText();
        } catch (TimeoutException e) {
            return ""; // Wenn die Fehlermeldung nicht sichtbar wird, bedeutet dies, dass sie nicht angezeigt wurde.
        }
    }
}