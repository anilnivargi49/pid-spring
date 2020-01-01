package com.pid.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.DeviceTemplates;

public interface DeviceTemplateRepository extends JpaRepository<DeviceTemplates, Integer> {

	@Query("SELECT d FROM DeviceTemplates d Where d.pidDevice.id=?1")
	public DeviceTemplates getDeviceTemplateByDeviceId(Integer id);
}
