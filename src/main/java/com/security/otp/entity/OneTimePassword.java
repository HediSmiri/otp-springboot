package com.security.otp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class OneTimePassword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    private String oneTimePasswordCode;

    @NonNull
    private Date expires;

    public @NonNull Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public @NonNull String getOneTimePasswordCode() {
        return oneTimePasswordCode;
    }

    public void setOneTimePasswordCode(@NonNull String oneTimePasswordCode) {
        this.oneTimePasswordCode = oneTimePasswordCode;
    }

    public @NonNull Date getExpires() {
        return expires;
    }

    public void setExpires(@NonNull Date expires) {
        this.expires = expires;
    }

}
