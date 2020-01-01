package com.pid.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "master_list")
public class MasterList {

	@Id
	@Column
	public Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid_ref")
	private PIDReference pidReference;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_area_id")
	private ServiceAreaCode serviceAreaCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id")
	private PIDDevice pidDevice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_function_id")
	private DeviceFunction deviceFunction;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "measurement_id")
	private Measurements measurement;

	@Column(name = "isa_code")
	private String isaCode;

	@Column(name = "loop_no")
	private Integer loopNo;

	@Column(name = "no_of_wires")
	private Integer noOfWires;

	@Column(name = "device_tag")
	private String deviceTag;

	@Column(name = "cable_tag")
	private String cableTag;

	@Column(name = "marshell_rack_id")
	private Integer marshellRackId;

	@Column(name = "marshell_rack_term")
	private String marshellRackTerm;

	@Column(name = "plc_panel_id")
	private String plcPanelId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PIDReference getPidReference() {
		return pidReference;
	}

	public void setPidReference(PIDReference pidReference) {
		this.pidReference = pidReference;
	}

	public ServiceAreaCode getServiceAreaCode() {
		return serviceAreaCode;
	}

	public void setServiceAreaCode(ServiceAreaCode serviceAreaCode) {
		this.serviceAreaCode = serviceAreaCode;
	}

	public PIDDevice getPidDevice() {
		return pidDevice;
	}

	public void setPidDevice(PIDDevice pidDevice) {
		this.pidDevice = pidDevice;
	}

	public DeviceFunction getDeviceFunction() {
		return deviceFunction;
	}

	public void setDeviceFunction(DeviceFunction deviceFunction) {
		this.deviceFunction = deviceFunction;
	}

	public Measurements getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurements measurement) {
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

	public String getCableTag() {
		return cableTag;
	}

	public void setCableTag(String cableTag) {
		this.cableTag = cableTag;
	}

	public Integer getMarshellRackId() {
		return marshellRackId;
	}

	public void setMarshellRackId(Integer marshellRackId) {
		this.marshellRackId = marshellRackId;
	}

	public String getMarshellRackTerm() {
		return marshellRackTerm;
	}

	public void setMarshellRackTerm(String marshellRackTerm) {
		this.marshellRackTerm = marshellRackTerm;
	}

	public String getPlcPanelId() {
		return plcPanelId;
	}

	public void setPlcPanelId(String plcPanelId) {
		this.plcPanelId = plcPanelId;
	}

}
