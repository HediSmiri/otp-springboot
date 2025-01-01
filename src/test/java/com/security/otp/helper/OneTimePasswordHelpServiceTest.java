package com.security.otp.helper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;

public class OneTimePasswordHelpServiceTest {

    @Test
    public void testCreateRandomOneTimePassword() {
        Supplier<String> otpSupplier = OneTimePasswordHelpService.createRandomOneTimePassword();
        String otp = otpSupplier.get();

        assertNotNull(otp, "OTP should not be null");
        assertEquals(6, otp.length(), "OTP should be 6 digits long");
        assertTrue(otp.matches("\\d{6}"), "OTP should only contain digits");
    }
}