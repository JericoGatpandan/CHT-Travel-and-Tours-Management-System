package com.cht.TravelAndToursManagement.client.repository.impl;

import com.cht.TravelAndToursManagement.client.model.Booking;
import com.cht.TravelAndToursManagement.client.repository.BookingRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepository {
    private final DataSource dataSource;

    public BookingRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Booking> findAll() {
        String sql = "SELECT * FROM booking";
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                bookings.add(mapBooking(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all bookings", e);
        }
        return bookings;
    }

    @Override
    public long countAll() {
        String sql = "SELECT COUNT(*) FROM booking";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error counting bookings", e);
        }
        return 0;
    }

    private Booking mapBooking(ResultSet rs) throws SQLException {
        Booking booking = new Booking();
        booking.setId(rs.getLong("id"));
        booking.setCustomerId(rs.getLong("customer_id"));
        booking.setBookingDate(rs.getDate("booking_date").toLocalDate());
        booking.setTotalAmount(rs.getBigDecimal("total_amount"));
        return booking;
    }

}
