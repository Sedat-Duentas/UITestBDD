package stepdefs;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import utils.TestUser;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Step Definitions für positive Benutzerregistrierungsszenarien.
 */
public class PositiveRegisterSteps {

    private HomePage homePage;
    private RegisterPage registerPage;
    private TestUser currentUser;

    public PositiveRegisterSteps(Hooks hooks) {

        this.homePage = hooks.getHomePage();
    }

    @When("the user navigates to the registration page for positive test")
    public void theUserNavigatesToTheRegistrationPageForPositiveTest() {
        registerPage = homePage.goToRegisterPage();
        currentUser = new TestUser(); // Erzeugt einen neuen, dynamischen Benutzer
    }

    @And("fills out the registration form with new user data")
    public void fillsOutTheRegistrationFormWithNewUserData() {
        registerPage.fillRegistrationForm(currentUser);
    }

    @And("clicks the register button")
    public void clicksTheRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        assertTrue(registerPage.isRegistrationSuccessful(), "Die Registrierung war nicht erfolgreich.");
    }

    @And("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        homePage = registerPage.clickContinueButton();
    }

    @And("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        assertTrue(homePage.isUserLoggedIn(), "Der Benutzer ist nach der Registrierung nicht eingeloggt.");
    }
}