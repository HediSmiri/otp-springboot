package com.security.otp.service;

import com.security.otp.entity.OneTimePassword;
import com.security.otp.helper.OneTimePasswordHelpService;
import com.security.otp.repository.OneTimePasswordRepository;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class OneTimePasswordService {

    private final Long expiryInterval = 5L * 60 * 1000;

    private final OneTimePasswordRepository oneTimePasswordRepository;

    public OneTimePasswordService(OneTimePasswordRepository oneTimePasswordRepository) {
        this.oneTimePasswordRepository = oneTimePasswordRepository;
    }

    public OneTimePassword returnOneTimePassword() {
        OneTimePassword oneTimePassword = new OneTimePassword();
        String otpSupplier = OneTimePasswordHelpService.createRandomOneTimePassword().get();
        oneTimePassword.setOneTimePasswordCode(otpSupplier);
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + expiryInterval));

        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }
}