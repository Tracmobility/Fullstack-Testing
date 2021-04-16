package com.example.contollers;


import com.example.models.Vehicle.Vehicle;
import com.example.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api")
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @CrossOrigin
    @RequestMapping(value = { "/vehicle" }, method = { RequestMethod.GET })
    public List<Vehicle> getVehicles( @RequestParam(required = false) Integer page){
        if(page != null) {
            return vehicleService.getVehiclesbyPage(page-1);
        }
        return vehicleService.getVehicles();
    }

    @CrossOrigin
    @RequestMapping(value = {"/vehicle/size"}, method= { RequestMethod.GET })
    public Long getSizeOfVehicles() {
        return vehicleService.getVehiclesSize();
    }
}
