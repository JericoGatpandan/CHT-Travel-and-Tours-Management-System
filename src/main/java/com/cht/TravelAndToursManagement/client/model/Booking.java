package com.cht.TravelAndToursManagement.client.model;


public class Booking {
    //# BOOKING
    //Booking_ID (PK)
    //Employee_ID (FK)
    //Client_ID (FK)
    //Package_ID (FK)
    //BookingDate
    //Status (pending, confirmed, cancelled)
    //PaxCount
    private int bookingId;
    private int employeeId;
    private int clientId;
    private int packageId;
    private String bookingDate;
    private String status;
    private int paxCount;

    public Booking(int bookingId, int employeeId, int clientId, int packageId, String bookingDate, String status, int paxCount) {
        this.bookingId = bookingId;
        this.employeeId = employeeId;
        this.clientId = clientId;
        this.packageId = packageId;
        this.bookingDate = bookingDate;
        this.status = status;
        this.paxCount = paxCount;
    }

    public Booking() {

    }

    public int getBookingId() {
        return bookingId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getPackageId() {
        return packageId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public int getPaxCount() {
        return paxCount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaxCount(int paxCount) {
        this.paxCount = paxCount;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }


}


