package com.cht.TravelAndToursManagement.repository;

import com.cht.TravelAndToursManagement.model.Client;
import java.util.List;

public interface ClientRepository {
    int count();
    
    List<Client> findByName();
    
}
