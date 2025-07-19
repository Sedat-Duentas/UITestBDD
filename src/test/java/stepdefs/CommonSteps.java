package stepdefs;

import io.cucumber.java.en.Given;

/**
 * Gemeinsame Step Definitions, die von mehreren Features verwendet werden können.
 */
public class CommonSteps {

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        // Die setUp-Methode in Hooks.java navigiert bereits zur Startseite. Diese Step-Definition dient primär dazu, den Gherkin-Schritt zu erfüllen.
    }
}