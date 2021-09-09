package com.bahadir.casestudy.vehicle;

public class Vehicle {
    private Long id;
    private String type;
    private String qr_code;
    private String status;
    private Double lat;
    private Double lng;
    private Double battery_level;

    public Vehicle() {
    }

    public Vehicle(Long id, String type, String qr_code, String status, Double lat, Double lng, Double battery_level) {
        this.id = id;
        this.type = type;
        this.qr_code = qr_code;
        this.status = status;
        this.lat = lat;
        this.lng = lng;
        this.battery_level = battery_level;
    }

    public Vehicle(String type, String qr_code, String status, Double lat, Double lng, Double battery_level) {
        this.type = type;
        this.qr_code = qr_code;
        this.status = status;
        this.lat = lat;
        this.lng = lng;
        this.battery_level = battery_level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(Double battery_level) {
        this.battery_level = battery_level;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", qr_code='" + qr_code + '\'' +
                ", status='" + status + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", battery_level=" + battery_level +
                '}';
    }
}
