package com.cht.TravelAndToursManagement.client.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class Employee {
    private final SimpleStringProperty name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty contactNumber;
    private final SimpleStringProperty isManager;
    private final SimpleStringProperty isActive;

    public Employee(String name, String email, String contactNumber, boolean isManager, boolean isActive) {
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.contactNumber = new SimpleStringProperty(contactNumber);
        this.isManager = new SimpleStringProperty(String.valueOf(isManager));
        this.isActive = new SimpleStringProperty(String.valueOf(isActive));
    }

    // Getters
    public String getName() {
        return name.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getContactNumber() {
        return contactNumber.get();
    }

    public SimpleStringProperty isManager() {
        return isManager;
    }

    public SimpleStringProperty isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }

    //    public void setIsManager(boolean manager) {
//        isManager = manager;
//    }
    public ObservableValue<String> nameProperty() {
        return name;
    }

    public ObservableValue<String> emailProperty() {
        return email;
    }

    public ObservableValue<String> contactNumberProperty() {
        return contactNumber;
    }

    public ObservableValue<String> isManagerProperty() {
        return isManager;
    }

    public ObservableValue<String> isActiveProperty() {
        return isActive;
    }
}
