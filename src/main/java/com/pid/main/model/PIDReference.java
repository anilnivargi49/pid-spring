package com.pid.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pid_reference")
public class PIDReference {

	@Id
	@Column
	private Integer id;

	@Column(name = "pid_reference")
	private String PIDReference;

	@Column
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPIDReference() {
		return PIDReference;
	}

	public void setPIDReference(String pIDReference) {
		PIDReference = pIDReference;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
