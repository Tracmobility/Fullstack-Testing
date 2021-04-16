package com.example.services;

import com.example.models.Vehicle.Vehicle;
import com.example.models.Vehicle.VehicleStatus;
import com.example.models.Vehicle.VehicleType;
import com.example.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class VehicleService {
    private final VehicleRepository vehicleRepository;


    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Long getVehiclesSize() {
        return vehicleRepository.count();
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }


    public List<Vehicle> getVehiclesbyPage(int page) {
        int range1= 0;
        int range2 = 5;

        if(page != 0) {
            range1= page*5 +1 ;
            range2= range1 + 4;
        }
        return vehicleRepository.findWithPagination(range1, range2);
    }

    @Transactional
    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
}