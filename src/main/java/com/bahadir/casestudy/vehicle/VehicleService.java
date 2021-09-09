package com.bahadir.casestudy.vehicle;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {


    public List<Vehicle> getVehicles(String vehiclesJSON) {

        JSONObject jsonObject = new JSONObject(vehiclesJSON);
        JSONArray jsonArray = jsonObject.getJSONArray("vehicles");

        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        if (jsonArray != null) {

            //Iterating JSON array
            for (int i = 0; i < jsonArray.length(); i++) {

                //Adding each element of JSON array into arraylist as Vehicle objects.
                JSONObject o = jsonArray.getJSONObject(i);
                vehicleList.add(new Vehicle(
                        o.getLong("id"),
                        o.getString("type"),
                        o.getString("qr_code"),
                        o.getString("status"),
                        o.getDouble("lat"),
                        o.getDouble("lng"),
                        o.getDouble("battery_level")
                ));
            }
        }

        return vehicleList;
    }

}
