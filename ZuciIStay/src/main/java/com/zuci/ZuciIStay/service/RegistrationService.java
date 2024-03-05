package com.zuci.ZuciIStay.service;

import com.zuci.ZuciIStay.model.Registration;

import java.util.List;

public interface RegistrationService {
    public Registration createUser(Registration registration);
    public Registration addDetails(Registration registration);
    public List<Registration> findBookingByUserId(int userId);
}
