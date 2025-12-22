package com.cht.TravelAndToursManagement.repository;

import com.cht.TravelAndToursManagement.model.Booking;

import java.util.List;

public interface BookingRepository {
    List<Booking> findAll();

    long countAll();

    int countByStatus(String status);

}
