package com.example.models.Vehicle;

import javax.persistence.*;

@Entity
public class Vehicle {
        @Id
        private int id;
        @Enumerated(EnumType.STRING)
        private VehicleType vehicleType;
        private String qr_code;
        @Enumerated(EnumType.STRING)
        private VehicleStatus vehicleStatus;
        private double lat;
        private double lng;
        private double battery_level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getType() {
        return vehicleType;
    }

    public void setType(VehicleType type) {
        this.vehicleType = type;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    public VehicleStatus getStatus() {
        return vehicleStatus;
    }

    public void setStatus(VehicleStatus status) {
        this.vehicleStatus = status;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(double battery_level) {
        this.battery_level = battery_level;
    }
}
