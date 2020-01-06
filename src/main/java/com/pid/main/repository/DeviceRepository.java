package com.pid.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.PIDDevice;

public interface DeviceRepository extends JpaRepository<PIDDevice, Integer> {

	@Query("SELECT d FROM PIDDevice d Where d.deviceName=?1")
	public PIDDevice getDeviceByDeviceName(String deviceName);

}
