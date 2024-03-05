package com.zuci.ZuciIStay.repository;

import com.zuci.ZuciIStay.dto.HotelName;
import com.zuci.ZuciIStay.model.PlaceHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlaceHotelRepository extends JpaRepository<PlaceHotel,Integer> {
}

