package com.pid.main.dto;

import com.pid.main.model.Measurements;

public class MeasurementDTO {

	private Integer id;
	private Integer deviceFunctionId;
	private String measurement;

	public MeasurementDTO(Measurements measurement) {
		this.id = measurement.getId();
		this.measurement = measurement.getMeasurement();
		this.deviceFunctionId = measurement.getDeviceFunction().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public Integer getDeviceFunctionId() {
		return deviceFunctionId;
	}

	public void setDeviceFunctionId(Integer deviceFunctionId) {
		this.deviceFunctionId = deviceFunctionId;
	}
}
