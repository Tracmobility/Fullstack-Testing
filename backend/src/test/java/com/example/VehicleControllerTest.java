package com.example;

import com.example.contollers.VehicleController;
import com.example.models.Vehicle.Vehicle;
import com.example.repositories.VehicleRepository;
import com.example.services.VehicleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private VehicleService vehicleService;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    private int seedDataTotalVehicleCount = 12;

    @Test
    public void CheckTotalCountOfVehicles() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/size").content("application/json");
        MvcResult result = this.mvc.perform(requestBuilder).andExpect(status().isOk())
                .andReturn();
        int size = Integer.parseInt(result.getResponse().getContentAsString());
        assertEquals(size , 12);
    }

    @Test
    public void RetrieveAllVehicles() throws Exception {
        List<Vehicle> list = vehicleService.getVehicles();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle").content("application/json");
        MvcResult result = this.mvc.perform(requestBuilder).andExpect(status().isOk())
        .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Vehicle>>() {});

        //check object classes
        assertEquals(list.get(0).getClass(), actual.get(0).getClass());

        //check sizes
        assertEquals(list.size() , actual.size());

        //check first item
        assertEquals(list.get(0).getId(), actual.get(0).getId());

    }

    @Test
    public void RetrieveFirstPageWith5Vehicles() throws Exception {
        List<Vehicle> list = vehicleService.getVehicles();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle?page=1").content("application/json");
        MvcResult result = this.mvc.perform(requestBuilder).andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Vehicle>>() {});

        assertEquals(actual.size() , 5);

        checkSameValuesOrNot(actual ,list, 0 );
    }

    @Test
    public void RetrieveSecondPageWith5Vehicles() throws Exception {
        List<Vehicle> list = vehicleService.getVehicles();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle?page=2").content("application/json");
        MvcResult result = this.mvc.perform(requestBuilder).andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Vehicle>>() {});

        assertEquals(actual.size() , 5);
        checkSameValuesOrNot(actual ,list, 5 );
    }

    public void checkSameValuesOrNot(List<Vehicle> response , List<Vehicle> actual, int index) {
        int i = index;
        for(Vehicle vehicle : response) {
            assertEquals(vehicle.getId(), actual.get(i).getId());
            assertEquals(vehicle.getType(), actual.get(i).getType());
            assertEquals(vehicle.getStatus(), actual.get(i).getStatus());
            assertEquals(vehicle.getQr_code(), actual.get(i).getQr_code());
            i++;
        }
    }

}