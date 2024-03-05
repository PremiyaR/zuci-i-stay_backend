package com.zuci.ZuciIStay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookingData {
    @Id
    private String username;
    private String place;
    private String hotelName;
    private String roomType;
    private LocalDate fromDate;
    private LocalDate toDate;

}
