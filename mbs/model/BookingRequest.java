package com.example.mbs.model;

import java.time.LocalDate;

public class BookingRequest {
    private int userId;
    private int boatHouseId;
    private LocalDate startDate;
    private LocalDate endDate;

    public BookingRequest() {}

    public BookingRequest(int userId, int boatHouseId, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.boatHouseId = boatHouseId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getBoatHouseId(){
        return boatHouseId;
    }

    public void setBoatHouseId(int boatHouseId){
        this.boatHouseId = boatHouseId;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }
}
