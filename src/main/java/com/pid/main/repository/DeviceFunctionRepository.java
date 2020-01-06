package com.pid.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.DeviceFunction;
import com.pid.main.model.PIDDevice;

public interface DeviceFunctionRepository extends JpaRepository<DeviceFunction, Integer> {

	@Query("SELECT f FROM DeviceFunction f Where f.pidDevice=?1 AND f.deviceFunction =?2")
	public DeviceFunction getDevFunctionByFunctionName(PIDDevice pidDevice, String function);
}
