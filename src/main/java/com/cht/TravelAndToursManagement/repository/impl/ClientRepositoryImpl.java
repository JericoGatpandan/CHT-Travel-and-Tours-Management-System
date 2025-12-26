package com.cht.TravelAndToursManagement.repository.impl;


import com.cht.TravelAndToursManagement.model.Client;
import javax.sql.DataSource;
import com.cht.TravelAndToursManagement.repository.ClientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {
    private final DataSource dataSource;
    
    public ClientRepositoryImpl(DataSource dataSource) {
        // Initialize with data source if needed
        this.dataSource = dataSource;

    }
    
    

    @Override
    public int count() {
        // Dummy implementation, replace with actual database logic
        return 42; // Example static return value
    }

    @Override
    public List<Client> findByName(String keyword) {
        String sql = "SELECT clientId, name, email, contactNumber FROM client WHERE name LIKE ? ORDER BY name";
        return queryClients(keyword, sql);
    }

    @Override
    public List<Client> findByNameOrEmail(String keyword) {
        String sql = "SELECT clientId, name, email, contactNumber FROM client WHERE name LIKE ? OR email LIKE ? ORDER BY name";
        List<Client> clients = new java.util.ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String like = "%" + keyword + "%";
            ps.setString(1, like);
            ps.setString(2, like);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clients.add(mapClient(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    private List<Client> queryClients(String keyword, String sql) {
        List<Client> clients = new java.util.ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clients.add(mapClient(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }

    private Client mapClient(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setClientId(rs.getInt("clientId"));
        client.setClientName(rs.getString("name"));
        client.setEmail(rs.getString("email"));
        client.setContactNumber(rs.getString("contactNumber"));
        return client;
    }


}
