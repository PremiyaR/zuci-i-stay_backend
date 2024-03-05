package com.zuci.ZuciIStay.controller;
import com.zuci.ZuciIStay.model.BookingData;
import com.zuci.ZuciIStay.model.Hotel;
import com.zuci.ZuciIStay.model.PlaceHotel;
import com.zuci.ZuciIStay.model.Room;
import com.zuci.ZuciIStay.service.ZuciIStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
public class ZuciIStayController {
    @Autowired
    private ZuciIStayService zuciIStayService;
    @PostMapping("/placesAdd")
    public PlaceHotel addPlace(@RequestBody PlaceHotel placeHotel){
        return zuciIStayService.addPlace(placeHotel);
    }
    @GetMapping("/places")
    public List<PlaceHotel> findAllData(){
        return zuciIStayService.findAllData();
    }
    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return zuciIStayService.addHotel(hotel);
    }
    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room){
        return zuciIStayService.addRoom(room);
    }
    @GetMapping("/hotel/{placeId}")
    public List<PlaceHotel> getHotelsByPlaceId(@PathVariable int placeId) {
        return zuciIStayService.findHotelsByPlaceId(placeId);
    }
    @GetMapping("/room/{hotelId}")
    public List<Hotel> getRoomByHotelId(@PathVariable int hotelId) {
        return zuciIStayService.findRoomByHotelId(hotelId);
    }

}
