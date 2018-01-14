package com.lc.travel.entity;

public class Travel {
    private Integer id;

    private String name;

    private Integer seats;

    private String date;

    private String plate;

    private String carowner;

    private String driver;

    private String driverphone;

    private String guide;

    private String guidephone;

    private String destination;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate == null ? null : plate.trim();
    }

    public String getCarowner() {
        return carowner;
    }

    public void setCarowner(String carowner) {
        this.carowner = carowner == null ? null : carowner.trim();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone == null ? null : driverphone.trim();
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide == null ? null : guide.trim();
    }

    public String getGuidephone() {
        return guidephone;
    }

    public void setGuidephone(String guidephone) {
        this.guidephone = guidephone == null ? null : guidephone.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }
}