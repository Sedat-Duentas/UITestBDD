package utils;

import java.util.UUID;

/**
 * Repräsentiert einen Testnutzer mit festen Stammdaten und dynamisch generierter E-Mail-Adresse.
 */

public class TestUser {
    public final String firstName = "Max";
    public final String lastName = "Mustermann";
    public final String email;
    public final String password = "Test1234!";

    // Standardkonstruktor für dynamische E-Mail-Generierung
    public TestUser() {
        this.email = "testuser_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }
}
