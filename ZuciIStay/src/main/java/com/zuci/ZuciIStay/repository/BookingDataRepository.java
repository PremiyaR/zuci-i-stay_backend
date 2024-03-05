package com.zuci.ZuciIStay.repository;

import com.zuci.ZuciIStay.model.BookingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDataRepository extends JpaRepository<BookingData,String> {
}
