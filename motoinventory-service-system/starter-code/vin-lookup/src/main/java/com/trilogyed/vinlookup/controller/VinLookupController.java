package com.trilogyed.vinlookup.controller;

import com.trilogyed.vinlookup.dao.VehicleDao;
import com.trilogyed.vinlookup.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@RestController
@RefreshScope
public class VinLookupController {

    @Autowired
    VehicleDao dao;

    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET)
    public HashMap lookUpVehicle(@PathVariable String vin) {

        Optional<Vehicle> potentialVehicle = Optional.ofNullable(dao.findVehicleByVin(vin));

        if (potentialVehicle.isPresent()) {
            Map<String, Vehicle> result = new HashMap<>();
            result.put("vehicle", potentialVehicle.get());
            return (HashMap) result;
        } else {
            return null;
        }
    }
}
