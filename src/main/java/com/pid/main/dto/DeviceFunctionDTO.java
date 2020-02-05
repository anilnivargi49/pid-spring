package com.pid.main.dto;

import com.pid.main.model.DeviceFunction;

public class DeviceFunctionDTO {

	private Integer id;
	private Integer deviceId;
	private String deviceFunction;

	public DeviceFunctionDTO(DeviceFunction deviceFunction) {
		this.id = deviceFunction.getId();
		this.deviceFunction = deviceFunction.getDeviceFunction();
		this.deviceId = deviceFunction.getPidDevice().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeviceFunction() {
		return deviceFunction;
	}

	public void setDeviceFunction(String deviceFunction) {
		this.deviceFunction = deviceFunction;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

}
