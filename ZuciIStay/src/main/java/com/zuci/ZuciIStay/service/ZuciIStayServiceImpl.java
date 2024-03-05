package com.zuci.ZuciIStay.service;
import com.zuci.ZuciIStay.dto.HotelName;
import com.zuci.ZuciIStay.exception.NoHotelPresentException;
import com.zuci.ZuciIStay.exception.NoRoomAvailableException;
import com.zuci.ZuciIStay.model.*;
import com.zuci.ZuciIStay.repository.HotelRepository;
import com.zuci.ZuciIStay.repository.PlaceHotelRepository;
import com.zuci.ZuciIStay.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ZuciIStayServiceImpl implements ZuciIStayService {
    @Autowired
    private PlaceHotelRepository placeHotelRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelBookingService hotelBookingService;
    @Override
    public PlaceHotel addPlace(PlaceHotel placeHotel){
        return placeHotelRepository.save(placeHotel);
    }
    @Override
    public Hotel addHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    @Override
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }
    @Override
    public List<PlaceHotel> findAllData() {
        return placeHotelRepository.findAll();
    }


     public List<PlaceHotel> findHotelsByPlaceId(int placeId) {
         Optional<PlaceHotel> optionalHotel = placeHotelRepository.findById(placeId);
         if(optionalHotel.isPresent()){
         List<PlaceHotel> hotelList = optionalHotel
                 .map(Collections::singletonList) // Converts to List
                 .orElse(Collections.emptyList());
        return hotelList;}
         else{
             throw new NoHotelPresentException();
         }


    }

    @Override
    public List<Hotel> findRoomByHotelId(int hotelId) {
        Optional<Hotel> optionalRoom = hotelRepository.findById(hotelId);
        if(optionalRoom.isPresent()){
        List<Hotel> roomList = optionalRoom
                .map(Collections::singletonList) // Converts to List
                .orElse(Collections.emptyList());
        return roomList;}
        else{
            throw new NoRoomAvailableException();
        }
    }

    @Override
    public List<HotelName> getAllHotelName(int placeId) {
        return null;
    }

}
