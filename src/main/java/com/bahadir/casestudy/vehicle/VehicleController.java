package com.bahadir.casestudy.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/vehicle")
public class VehicleController {

    private final String vehiclesJSON = "{\"vehicles\" : [{\"id\": 1, \"type\":"
            + " \"SCOOTER\", \"qr_code\": \"QR_0001\", \"status\": \"AVAILABLE\", "
            + " \"lat\": 51.6432, \"lng\": -0.0985, \"battery_level\": 0.15},"
            + " {\"id\": 2, \"type\":"
            + " \"SCOOTER\", \"qr_code\": \"QR_0002\", \"status\": \"RUNNING\", "
            + " \"lat\": 45.87867, \"lng\": -0.0673, \"battery_level\": 0.95},"
            + " {\"id\": 3, \"type\":"
            + " \"SCOOTER\", \"qr_code\": \"QR_0003\", \"status\": \"REPAIRING\", "
            + " \"lat\": 49.989898, \"lng\": -0.0985, \"battery_level\": 0.65},"
            + " {\"id\": 4, \"type\":"
            + " \"BIKE\", \"qr_code\": \"QR_0004\", \"status\": \"AVAILABLE\", "
            + " \"lat\": 52.010110, \"lng\": -0.078903, \"battery_level\": 0.45},"
            + " {\"id\": 5, \"type\":"
            + " \"E-BIKE\", \"qr_code\": \"QR_0005\", \"status\": \"AVAILABLE\", "
            + " \"lat\": 39.232324, \"lng\": -0.0157323, \"battery_level\": 0.15},"
            + " {\"id\": 6, \"type\":"
            + " \"SCOOTER\", \"qr_code\": \"QR_0006\", \"status\": \"AVAILABLE\", "
            + " \"lat\": 39.232324, \"lng\": -0.0985, \"battery_level\": 0.05}"
            + " ]}";

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles(vehiclesJSON);
    }
}
