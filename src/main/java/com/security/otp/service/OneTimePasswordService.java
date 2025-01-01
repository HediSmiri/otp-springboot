package com.security.otp.service;

import com.security.otp.entity.OneTimePassword;
import com.security.otp.helper.OneTimePasswordHelpService;
import com.security.otp.repository.OneTimePasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class OneTimePasswordService {

    private final Long expiryInterval = 5L * 60 * 1000;

    private final OneTimePasswordRepository oneTimePasswordRepository;

    private final OneTimePasswordHelpService oneTimePasswordHelpService;

    public OneTimePassword returnOneTimePassword() {
        OneTimePassword oneTimePassword = new OneTimePassword();
        Supplier<String> otpSupplier = OneTimePasswordHelpService.createRandomOneTimePassword();
        oneTimePassword.setOneTimePasswordCode(otpSupplier.get());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + expiryInterval));

        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }
}