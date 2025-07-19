package stepdefs;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import utils.TestUser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Step Definitions für negative Benutzerregistrierungsszenarien.
 */
public class NegativeRegisterSteps {

    private HomePage homePage;
    private RegisterPage registerPage;
    private TestUser testUserForNegativeScenario;

    public NegativeRegisterSteps(Hooks hooks) {
        this.homePage = hooks.getHomePage();
    }

    @Given("a user is successfully registered with a new email and then logged out")
    public void aUserIsSuccessfullyRegisteredWithANewEmailAndThenLoggedOut() {
        testUserForNegativeScenario = new TestUser();

        registerPage = homePage.goToRegisterPage();
        registerPage.fillRegistrationForm(testUserForNegativeScenario);
        registerPage.clickRegisterButton();

        assertTrue(registerPage.isRegistrationSuccessful(), "Setup: Die initiale Registrierung des Test-Benutzers war nicht erfolgreich.");
        homePage = registerPage.clickContinueButton();
        homePage.logout();
        assertFalse(homePage.isUserLoggedIn(), "Setup: Benutzer sollte nach der initialen Registrierung und Logout nicht eingeloggt sein.");
    }

    @When("the user navigates to the registration page for a re-registration attempt")
    public void theUserNavigatesToTheRegistrationPageForAReRegistrationAttempt() {
        registerPage = homePage.goToRegisterPage();
    }

    @And("attempts to register again with the same user data")
    public void attemptsToRegisterAgainWithTheSameUserData() {
        if (testUserForNegativeScenario == null) {
            throw new RuntimeException("Kein Benutzer für den Registrierungsversuch verfügbar. Der 'Given'-Schritt wurde nicht korrekt ausgeführt.");
        }
        registerPage.fillRegistrationForm(testUserForNegativeScenario);
    }

    @And("attempts to register by clicking the button")
    public void attemptsToRegisterByClickingTheButton() {
        registerPage.clickRegisterButton();
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = registerPage.getRegistrationErrorMessage();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Erwartete Fehlermeldung '" + expectedErrorMessage + "' wurde nicht angezeigt oder stimmte nicht überein. Tatsächlich: '" + actualErrorMessage + "'");
    }
}