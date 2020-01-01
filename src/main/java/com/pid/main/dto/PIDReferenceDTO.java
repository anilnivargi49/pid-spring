package com.pid.main.dto;

public class PIDReferenceDTO {

	private Integer id;
	private String pidReference;
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPidReference() {
		return pidReference;
	}

	public void setPidReference(String pidReference) {
		this.pidReference = pidReference;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
