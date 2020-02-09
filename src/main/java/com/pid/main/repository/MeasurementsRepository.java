package com.pid.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.DeviceFunction;
import com.pid.main.model.Measurements;

public interface MeasurementsRepository extends JpaRepository<Measurements, Integer> {

	@Query("SELECT m FROM Measurements m Where m.deviceFunction=?1 AND m.id=?2")
	public Measurements getMeasurementsByMeasurementName(DeviceFunction deviceFunction, Integer measurementId);

	@Query("SELECT m FROM Measurements m Where m.deviceFunction=?1")
	public List<Measurements> findAllByFunction(DeviceFunction deviceFunction);

	@Query("SELECT m FROM Measurements m Where m.id=?1")
	public Measurements getMeasurementById(Integer measurementId);
}
