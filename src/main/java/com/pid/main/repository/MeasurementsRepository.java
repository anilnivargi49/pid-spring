package com.pid.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.DeviceFunction;
import com.pid.main.model.Measurements;

public interface MeasurementsRepository extends JpaRepository<Measurements, Integer> {

	@Query("SELECT m FROM Measurements m Where m.deviceFunction=?1 AND m.measurement=?2")
	public Measurements getMeasurementsByMeasurementName(DeviceFunction deviceFunction, String measurement);
}
