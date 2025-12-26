package com.cht.TravelAndToursManagement.repository;

import com.cht.TravelAndToursManagement.model.Client;
import java.util.List;

public interface ClientRepository {
    int count();
    // Find clients by matching name or email (partial match)
    List<Client> findByName(String keyword);
    List<Client> findByNameOrEmail(String keyword);
}
