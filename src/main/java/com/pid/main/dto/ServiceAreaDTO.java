package com.pid.main.dto;

import com.pid.main.model.ServiceAreaCode;

public class ServiceAreaDTO {

	private Integer id;
	private String serviceArea;
	private Integer areaCode;

	public ServiceAreaDTO(ServiceAreaCode serviceAreaCode) {
		this.id = serviceAreaCode.getId();
		this.serviceArea = serviceAreaCode.getServiceArea();
		this.areaCode = serviceAreaCode.getAreaCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

}
