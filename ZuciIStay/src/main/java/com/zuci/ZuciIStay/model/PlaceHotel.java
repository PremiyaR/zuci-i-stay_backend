package com.zuci.ZuciIStay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlaceHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeId;
    private String place;
    @OneToMany(targetEntity = Hotel.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="joinHotel",referencedColumnName = "placeId")
    private List<Hotel> hotel;
}
