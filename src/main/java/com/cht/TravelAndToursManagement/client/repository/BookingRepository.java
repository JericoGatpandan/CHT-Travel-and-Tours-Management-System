package com.cht.TravelAndToursManagement.client.repository;

import com.cht.TravelAndToursManagement.client.model.Booking;

import java.util.List;

public interface BookingRepository {
    List<Booking> findAll();

    long countAll();

    int countByStatus(String status);

}
