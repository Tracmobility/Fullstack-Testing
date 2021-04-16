package com.example;

import com.example.models.Vehicle.Vehicle;
import com.example.models.Vehicle.VehicleStatus;
import com.example.models.Vehicle.VehicleType;
import com.example.repositories.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class VehicleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VehicleRepository vehicleRepository;

    private Long SeedDataSize = 12L;
    private int intSeedDataSize = 12;

    @Rollback(false)
    @Test
    public void testRetrieveVehicles() throws Exception {
        List<Vehicle> list = vehicleRepository.findAll();
        assertEquals(intSeedDataSize , list.size());
    }

    @Rollback(false)
    @Test
    public void testRetrieveVehiclesSizeCount() throws Exception {
        Long size = vehicleRepository.count();
        assertEquals(SeedDataSize , size);
    }

    @Rollback(false)
    @Test
    public void testRetrieveVehiclesWithPagination0to5() throws Exception {
        List<Vehicle> rangelist = vehicleRepository.findWithPagination(0, 5);
        List<Vehicle> list = vehicleRepository.findAll();

        for(int i = 0; i< rangelist.size(); i++) {
            assertEquals(rangelist.get(i) , list.get(i));
        }

        assertEquals(5 , rangelist.size());
    }

    @Rollback(false)
    @Test
    public void testRetrieveVehiclesWithPagination5to10() throws Exception {
        List<Vehicle> rangelist = vehicleRepository.findWithPagination(6, 10);
        List<Vehicle> list = vehicleRepository.findAll();

        int j = 0;
        for(int i = 5; i< 10; i++) {
            assertEquals(rangelist.get(j) , list.get(i));
            j++;
        }
        assertEquals(5 , rangelist.size());
    }

    @Test
    public void testInsertAndRetrieveVehicleWithMockRepository() throws Exception {

        try{
            Vehicle v = new Vehicle();
            v.setBattery_level(0.15);
            v.setLat(0.15);
            v.setLng(0.15);
            v.setQr_code("QR_0001");
            v.setStatus(VehicleStatus.AVAILABLE);
            v.setType( VehicleType.SCOOTER);
            entityManager.persist(v);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        List<Vehicle> list = vehicleRepository.findAll();
        assertEquals(SeedDataSize + 1 , list.size());
    }
}
