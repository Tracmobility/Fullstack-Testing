package com.example.repositories;

import com.example.models.Vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository
        extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v From Vehicle v Where v.id between ?1 and ?2")
    List<Vehicle> findWithPagination(int range1,  int range2);

}
