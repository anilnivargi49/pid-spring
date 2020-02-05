package com.pid.main.dto;

import java.util.ArrayList;
import java.util.List;

import com.pid.main.model.DeviceFunction;
import com.pid.main.model.Measurements;
import com.pid.main.model.PIDDevice;
import com.pid.main.model.PIDReference;
import com.pid.main.model.ServiceAreaCode;

public class MasterListDTO {

	private int id;
	private String pidReference;
	private List<PIDReferenceDTO> pidReferenceList;
	private String serviceArea;
	private List<ServiceAreaDTO> serviceAreaList;
	private String deviceName;
	private List<DeviceDTO> deviceList;
	private String deviceFunction;
	private Integer deviceFunctionId;
	private List<DeviceFunctionDTO> deviceFunctionList;
	private String measurement;
	private Integer measurementId;
	private List<MeasurementDTO> measurementList;
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

	public List<PIDReferenceDTO> getPidReferenceList() {
		return pidReferenceList;
	}

	public void setPidReferenceList(List<PIDReferenceDTO> pidReferenceList) {
		this.pidReferenceList = pidReferenceList;
	}

	public void setPidReferenceListFromEntity(List<PIDReference> pidReferenceList) {

		List<PIDReferenceDTO> pidReferenceDTOList = new ArrayList<>();
		if (pidReferenceList != null && pidReferenceList.size() > 0) {
			for (PIDReference pidRef : pidReferenceList) {
				PIDReferenceDTO pidReferenceDTO = new PIDReferenceDTO(pidRef);
				pidReferenceDTOList.add(pidReferenceDTO);
			}
		}

		this.pidReferenceList = pidReferenceDTOList;
	}

	public List<ServiceAreaDTO> getServiceAreaList() {
		return serviceAreaList;
	}

	public void setServiceAreaList(List<ServiceAreaDTO> serviceAreaList) {
		this.serviceAreaList = serviceAreaList;
	}

	public void setServiceAreaListFromEntity(List<ServiceAreaCode> serviceAreaList) {

		List<ServiceAreaDTO> serviceAreaDTOList = new ArrayList<>();
		if (serviceAreaList != null && serviceAreaList.size() > 0) {
			for (ServiceAreaCode serviceArea : serviceAreaList) {
				ServiceAreaDTO serviceAreaCode = new ServiceAreaDTO(serviceArea);
				serviceAreaDTOList.add(serviceAreaCode);
			}
		}

		this.serviceAreaList = serviceAreaDTOList;
	}

	public List<DeviceDTO> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<DeviceDTO> deviceList) {
		this.deviceList = deviceList;
	}

	public void setDeviceListFromEntity(List<PIDDevice> deviceList) {

		List<DeviceDTO> deviceDTOList = new ArrayList<>();
		if (deviceList != null && deviceList.size() > 0) {
			for (PIDDevice pidDevice : deviceList) {
				DeviceDTO deviceDTO = new DeviceDTO(pidDevice);
				deviceDTOList.add(deviceDTO);
			}
		}

		this.deviceList = deviceDTOList;
	}

	public List<DeviceFunctionDTO> getDeviceFunctionList() {
		return deviceFunctionList;
	}

	public void setDeviceFunctionList(List<DeviceFunctionDTO> deviceFunctionList) {
		this.deviceFunctionList = deviceFunctionList;
	}

	public void setDeviceFunctionListFromEntity(List<DeviceFunction> deviceFunctionList) {

		List<DeviceFunctionDTO> deviceFunctionDTOList = new ArrayList<>();
		if (deviceFunctionList != null && deviceFunctionList.size() > 0) {
			for (DeviceFunction pidDevice : deviceFunctionList) {
				DeviceFunctionDTO deviceFunctionDTO = new DeviceFunctionDTO(pidDevice);
				deviceFunctionDTOList.add(deviceFunctionDTO);
			}
		}

		this.deviceFunctionList = deviceFunctionDTOList;
	}

	public List<MeasurementDTO> getMeasurementList() {
		return measurementList;
	}

	public void setMeasurementList(List<MeasurementDTO> measurementList) {
		this.measurementList = measurementList;
	}

	public void setMeasurementListFromEntity(List<Measurements> measurementList) {

		List<MeasurementDTO> measurementDTOList = new ArrayList<>();
		if (measurementList != null && measurementList.size() > 0) {
			for (Measurements measurement : measurementList) {
				MeasurementDTO measurementDTO = new MeasurementDTO(measurement);
				measurementDTOList.add(measurementDTO);
			}
		}

		this.measurementList = measurementDTOList;
	}

	public Integer getDeviceFunctionId() {
		return deviceFunctionId;
	}

	public void setDeviceFunctionId(Integer deviceFunctionId) {
		this.deviceFunctionId = deviceFunctionId;
	}

	public Integer getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Integer measurementId) {
		this.measurementId = measurementId;
	}

}
