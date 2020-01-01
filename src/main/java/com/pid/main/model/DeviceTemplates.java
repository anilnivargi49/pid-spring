package com.pid.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device_templates")
public class DeviceTemplates {

	@Id
	@Column
	private Integer id;

	@OneToOne
	@JoinColumn(name = "device_id")
	private PIDDevice pidDevice;

	@Column(name = "device_template")
	private String templateContent;

	@Column
	private boolean active;

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

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
