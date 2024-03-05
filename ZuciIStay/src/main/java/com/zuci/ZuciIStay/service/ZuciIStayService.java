package com.zuci.ZuciIStay.service;

import com.zuci.ZuciIStay.dto.HotelName;
import com.zuci.ZuciIStay.model.BookingData;
import com.zuci.ZuciIStay.model.Hotel;
import com.zuci.ZuciIStay.model.PlaceHotel;
import com.zuci.ZuciIStay.model.Room;
import java.util.List;

public interface ZuciIStayService {
    public PlaceHotel addPlace(PlaceHotel placeHotel);
    public Hotel addHotel(Hotel hotel);
    public Room addRoom(Room room);
    public List<PlaceHotel> findAllData();
    List<PlaceHotel> findHotelsByPlaceId(int placeId);
    List<Hotel> findRoomByHotelId(int hotelId);
    List<HotelName> getAllHotelName(int placeId);
}

