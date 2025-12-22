package com.cht.TravelAndToursManagement.repository.impl;

import com.cht.TravelAndToursManagement.model.Booking;
import com.cht.TravelAndToursManagement.repository.BookingRepository;

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

    @Override
    public int countByStatus(String status) {
        String sql = "SELECT COUNT(*) FROM booking WHERE status = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error counting bookings by status", e);
        }
        return 0;
    }

    private Booking mapBooking(ResultSet rs) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingId(rs.getInt("employeeId"));
        booking.setClientId(rs.getInt("clientId"));
        booking.setBookingDate(String.valueOf(rs.getDate("bookingDate").toLocalDate()));
        booking.setStatus(rs.getString("status"));
        booking.setPaxCount(rs.getInt("paxCount"));

        return booking;
    }

}
