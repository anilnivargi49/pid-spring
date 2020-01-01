package com.pid.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "measurements")
public class Measurements {

	@Id
	@Column
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_function_id")
	private DeviceFunction deviceFunction;

	@Column
	private String measurement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DeviceFunction getDeviceFunction() {
		return deviceFunction;
	}

	public void setDeviceFunction(DeviceFunction deviceFunction) {
		this.deviceFunction = deviceFunction;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
}
