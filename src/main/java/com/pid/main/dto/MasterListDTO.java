package com.pid.main.dto;

public class MasterListDTO {

	private int id;
	private String pidReference;
	private String serviceArea;
	private String deviceName;
	private String deviceFunction;
	private String measurement;
	private String isaCode;
	private Integer loopNo;
	private Integer noOfWires;
	private String deviceTag;
	private String junctionBoxId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPidReference() {
		return pidReference;
	}

	public void setPidReference(String pidReference) {
		this.pidReference = pidReference;
	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceFunction() {
		return deviceFunction;
	}

	public void setDeviceFunction(String deviceFunction) {
		this.deviceFunction = deviceFunction;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public String getIsaCode() {
		return isaCode;
	}

	public void setIsaCode(String isaCode) {
		this.isaCode = isaCode;
	}

	public Integer getLoopNo() {
		return loopNo;
	}

	public void setLoopNo(Integer loopNo) {
		this.loopNo = loopNo;
	}

	public Integer getNoOfWires() {
		return noOfWires;
	}

	public void setNoOfWires(Integer noOfWires) {
		this.noOfWires = noOfWires;
	}

	public String getDeviceTag() {
		return deviceTag;
	}

	public void setDeviceTag(String deviceTag) {
		this.deviceTag = deviceTag;
	}

	public String getJunctionBoxId() {
		return junctionBoxId;
	}

	public void setJunctionBoxId(String junctionBoxId) {
		this.junctionBoxId = junctionBoxId;
	}

}
