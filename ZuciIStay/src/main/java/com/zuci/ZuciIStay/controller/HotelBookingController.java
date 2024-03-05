package com.zuci.ZuciIStay.controller;

import com.zuci.ZuciIStay.model.Booking;
import com.zuci.ZuciIStay.model.BookingData;
import com.zuci.ZuciIStay.service.HotelBookingService;
import com.zuci.ZuciIStay.service.JwtUtilityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class HotelBookingController {

    @Autowired
    private JwtUtilityService jwtUtilityService;
    @Autowired
    HotelBookingService hotelBookingService;
    @PostMapping("/bookingAdd")
    public Integer createHotelBooking(@Valid @RequestBody Booking booking, HttpServletRequest request)
    {

        Booking createdBooking=hotelBookingService.createBooking(booking);

        return createdBooking.getBookingId();

    }

    @PutMapping("/booking/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable("id") int bookingId,@RequestBody Booking updatedBooking)
    {
        try {
            Booking existingBooking = hotelBookingService.getBookingById(bookingId);
            if (existingBooking == null) {
                return ResponseEntity.notFound().build();

            }
            existingBooking.setPlace(updatedBooking.getPlace());
            existingBooking.setHotelName(updatedBooking.getHotelName());
            existingBooking.setFromDate(updatedBooking.getFromDate());
            existingBooking.setToDate((updatedBooking.getToDate()));
            existingBooking.setRoomType((updatedBooking.getRoomType()));

            Booking savedBooking=hotelBookingService.saveBooking(existingBooking);
            return ResponseEntity.ok(savedBooking);
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update:");
        }

    }

    @GetMapping("/bookingAll")
    public List<Booking> getAllHotelBooking()
    {
        return hotelBookingService.getAllBooking();
    }
    @GetMapping("/book/{id}")
    public Booking getHotelBookingById(@PathVariable("id") int id)
    {
        return hotelBookingService.getBookingById(id);
    }
    @DeleteMapping("/booking/{bookingId}")
    public String deleteHotelBooking(@PathVariable("bookingId") int bookingId)
    {
        return hotelBookingService.DeleteBookingById(bookingId);
    }
    @PostMapping("/booking")
    public boolean roomBookingByCheck(@RequestBody BookingData bookingData) {
        return hotelBookingService.roomBookingByCheck(bookingData);
    }
    @GetMapping("/booking/{username}")
    public List<Booking> getBookingDataOfUser(@PathVariable("username") String username)
    {
        return hotelBookingService.getBookingByUsername(username);
    }


}
