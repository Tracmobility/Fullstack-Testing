package com.bahadir.casestudy.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



class VehicleServiceTest {


    private VehicleService underTest;

    @BeforeEach
    void setUp() {
        underTest = new VehicleService();
    }

    @Test
    void itShouldGetVehicles() {
        // Given
        List<Vehicle> given = new ArrayList<>();
        given.add(new Vehicle(1L, "SCOOTER", "QR_0001", "AVAILABLE", 51.6432, -0.0985, 0.15));
        given.add(new Vehicle(2L, "SCOOTER", "QR_0002", "RUNNING", 45.87867, -0.0673, 0.95));

        String jsonFormattedVehiclesString = "{\"vehicles\" : [{\"id\": 1, \"type\":"
                + " \"SCOOTER\", \"qr_code\": \"QR_0001\", \"status\": \"AVAILABLE\", "
                + " \"lat\": 51.6432, \"lng\": -0.0985, \"battery_level\": 0.15},"
                + " {\"id\": 2, \"type\":"
                + " \"SCOOTER\", \"qr_code\": \"QR_0002\", \"status\": \"RUNNING\", "
                + " \"lat\": 45.87867, \"lng\": -0.0673, \"battery_level\": 0.95}"
                + " ]}";
        // When
        List<Vehicle> expected = underTest.getVehicles(jsonFormattedVehiclesString);

        // Then
        assertEquals(expected.size(), given.size());

    }
}