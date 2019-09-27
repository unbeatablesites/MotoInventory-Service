package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;

public interface VehicleDao {
    Vehicle findVehicleByVin(String vin);
}
