package com.cht.TravelAndToursManagement.client.repository.impl;

import com.cht.TravelAndToursManagement.client.repository.CustomerRepository;

import javax.sql.DataSource;

public class CustomerRepositoryImpl implements CustomerRepository {
    public CustomerRepositoryImpl(DataSource dataSource) {
        // Initialize with data source if needed

    }

    @Override
    public int count() {
        // Dummy implementation, replace with actual database logic
        return 42; // Example static return value
    }
}
