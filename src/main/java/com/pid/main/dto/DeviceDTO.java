package com.pid.main.dto;

import com.pid.main.model.PIDDevice;

public class DeviceDTO {

	private Integer id;
	private String deviceName;
	private boolean active;

	public DeviceDTO(PIDDevice pidDevice) {
		this.id = pidDevice.getId();
		this.deviceName = pidDevice.getDeviceName();
		this.active = pidDevice.isActive();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
