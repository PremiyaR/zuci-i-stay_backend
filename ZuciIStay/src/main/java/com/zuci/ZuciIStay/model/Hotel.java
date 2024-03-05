package com.zuci.ZuciIStay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    private String hotelName;
    @OneToMany(targetEntity = Room.class,cascade = CascadeType.ALL)
    @JoinColumn(name="joinRoom",referencedColumnName = "hotelId")
    private List<Room> rooms;

}
