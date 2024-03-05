package com.zuci.ZuciIStay.service;
import com.zuci.ZuciIStay.model.Booking;
import com.zuci.ZuciIStay.model.BookingData;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface HotelBookingService {

    Booking createBooking(Booking booking);
    List<Booking> getAllBooking();
    Booking getBookingById(int bookingId);
    Booking saveBooking(Booking booking);
    String DeleteBookingById(int bookingId);
    boolean roomBookingByCheck(BookingData bookingData);
    List<Booking> getBookingByUsername(String username);

}