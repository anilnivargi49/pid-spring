package com.pid.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device_function")
public class DeviceFunction {

	@Id
	@Column
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id")
	private PIDDevice pidDevice;

	@Column(name = "device_function")
	private String deviceFunction;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PIDDevice getPidDevice() {
		return pidDevice;
	}

	public void setPidDevice(PIDDevice pidDevice) {
		this.pidDevice = pidDevice;
	}

	public String getDeviceFunction() {
		return deviceFunction;
	}

	public void setDeviceFunction(String deviceFunction) {
		this.deviceFunction = deviceFunction;
	}

}
