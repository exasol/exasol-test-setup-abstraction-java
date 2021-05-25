package com.exasol.exasoltestsetup;

import java.security.SecureRandom;
import java.util.stream.Collectors;

/**
 * This class generates random passwords.
 */
public class PasswordGenerator {
    private PasswordGenerator() {
        // empty on purpose
    }

    /**
     * Generate a random password.
     * 
     * @return password
     */
    public static String generatePassword() {
        final SecureRandom random = new SecureRandom();
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return random.ints(25, 0, chars.length()).mapToObj(randomNumber -> String.valueOf(chars.charAt(randomNumber)))
                .collect(Collectors.joining());
    }
}
