package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Dies ist die Hauptklasse, um alle Cucumber-Tests (BDD-Szenarien) auszuführen. JUnit startet diese Klasse und übergibt die Kontrolle dann an Cucumber.
 */
@RunWith(Cucumber.class) // Sagt JUnit: "Lass Cucumber meine Tests ausführen, nicht den Standard-JUnit-Runner."
@CucumberOptions(
        // 'features' zeigt auf die Gherkin-Dateien (.feature), die unsere Tests beschreiben.
        features = "src/test/resources/features",

        // 'glue' sagt Cucumber, wo es die Java-Implementierungen der Gherkin-Schritte (Step Definitions und Hooks) findet.
        glue = {"stepdefs", "base"},

        // 'plugin' konfiguriert verschiedene Arten von Testberichten, die Cucumber erzeugen soll.
        plugin = {
                "pretty",                                                       // Für lesbare Ausgabe direkt in der Konsole
                "html:target/cucumber-reports/cucumber-html-report.html",       // Erzeugt einen interaktiven HTML-Bericht im Browser
                "json:target/cucumber-reports/cucumber.json",                   // Erzeugt einen maschinenlesbaren JSON-Bericht (für Tools)
                "junit:target/cucumber-reports/cucumber.xml"                    // Erzeugt einen XML-Bericht im JUnit-Format (für CI/CD-Systeme)
        },

        // 'monochrome = true' macht die Konsolenausgabe von Cucumber einfacher zu lesen (keine seltsamen Zeichen).
        monochrome = true,

        // 'snippets legt fest, wie Cucumber Snippets (Vorschläge für fehlende Steps) in Java-CamelCase generiert.
        snippets = CucumberOptions.SnippetType.CAMELCASE,

        // 'dryRun = false' bedeutet, dass die Tests wirklich ausgeführt werden (nicht nur auf fehlende Steps geprüft).
        dryRun = false
)
public class TestRunner {
        // Diese Klasse selbst ist leer, da ihre einzige Aufgabe darin besteht, JUnit die Anweisungen für Cucumber zu geben. Sie ist der 'Startpunkt'.
}