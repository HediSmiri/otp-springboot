package com.security.otp.contoller;

import com.security.otp.service.OneTimePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp/")
public class OneTimePasswordController {
    private final OneTimePasswordService oneTimePAsswordService;

    public OneTimePasswordController(OneTimePasswordService oneTimePAsswordService) {
        this.oneTimePAsswordService = oneTimePAsswordService;
    }

    @GetMapping("/create")
    private Object getOneTimePassword() {
        try {
            return ResponseEntity.ok(oneTimePAsswordService.returnOneTimePassword());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}