package com.pid.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "isa_codes")
public class ISACode {

	@Id
	@Column
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "measurement_id")
	private Measurements measurement;

	@Column(name = "isa_code")
	private String isaCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
