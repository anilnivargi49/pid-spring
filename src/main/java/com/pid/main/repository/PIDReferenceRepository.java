package com.pid.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.PIDReference;

public interface PIDReferenceRepository extends JpaRepository<PIDReference, Integer> {

	@Query("SELECT r FROM PIDReference r Where r.PIDReference=?1")
	public PIDReference getReferenceByRefName(String refName);

}
