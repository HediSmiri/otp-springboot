package com.security.otp.helper;

import java.util.Random;
import java.util.function.Supplier;

import java.security.SecureRandom;

public class OneTimePasswordHelpService {

    private static final int LENGTH = 6;
    private static final SecureRandom secureRandom = new SecureRandom(); // Reusable instance for better performance

    public static Supplier<String> createRandomOneTimePassword() {
        return () -> {
            StringBuilder oneTimePassword = new StringBuilder(LENGTH);
            for (int i = 0; i < LENGTH; i++) {
                int randomNumber = secureRandom.nextInt(10);  // Using SecureRandom for better randomness
                oneTimePassword.append(randomNumber);
            }
            return oneTimePassword.toString();
        };
    }
}
