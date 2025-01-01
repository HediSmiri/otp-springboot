package com.security.otp.repository;

import com.security.otp.entity.OneTimePassword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Long> {
}
