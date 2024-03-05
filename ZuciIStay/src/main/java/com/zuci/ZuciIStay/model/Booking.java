package com.zuci.ZuciIStay.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String username;
    @NotBlank(message = "place name should not be blank")
    private String place;
    @NotBlank(message = "Hotel name should not be blank")
    private String hotelName;
    @NotBlank(message = "room type should not be blank")
    private String roomType;
    @FutureOrPresent
    private LocalDate fromDate;
    @FutureOrPresent
    private LocalDate toDate;
}
