package com.zuci.ZuciIStay.repository;

import com.zuci.ZuciIStay.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
    public Registration findByUsername(String username);
}
