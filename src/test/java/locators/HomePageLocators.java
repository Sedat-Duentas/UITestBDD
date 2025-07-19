package locators;

import org.openqa.selenium.By;

/**
 * Enthält alle Locator-Definitionen für die Startseite.
 */
public class HomePageLocators {
    public static final By REGISTER_LINK = By.className("ico-register");
    public static final By LOGOUT_LINK = By.className("ico-logout");
    public static final By LOGGED_IN_ACCOUNT_LINK = By.cssSelector(".header-links .account");
}