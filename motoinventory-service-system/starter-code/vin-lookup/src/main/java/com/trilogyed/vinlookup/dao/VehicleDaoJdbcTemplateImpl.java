package com.trilogyed.vinlookup.dao;

import com.trilogyed.vinlookup.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class VehicleDaoJdbcTemplateImpl implements VehicleDao {

    private String GET_BY_VIN_SQL =
            "select make, model, year, color from motorcycle where vin = ?";

    private final JdbcTemplate sql;

    @Autowired
    public VehicleDaoJdbcTemplateImpl(JdbcTemplate sql) {
        this.sql = sql;
    }

    @Override
    public Vehicle findVehicleByVin(String vin) {
        try {
            return sql.queryForObject(GET_BY_VIN_SQL, this::mapRowToVehicle, vin);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    private Vehicle mapRowToVehicle(ResultSet set, int rowNumber) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(set.getMetaData().getTableName(1));
        vehicle.setMake(set.getString("make"));
        vehicle.setModel("model");
        vehicle.setYear(set.getString("year"));
        vehicle.setColor(set.getString("color"));
        return vehicle;
    }
}
