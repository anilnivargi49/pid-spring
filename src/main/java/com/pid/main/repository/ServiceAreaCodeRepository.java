package com.pid.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.ServiceAreaCode;

public interface ServiceAreaCodeRepository extends JpaRepository<ServiceAreaCode, Integer> {

	@Query("SELECT s FROM ServiceAreaCode s Where s.serviceArea=?1")
	public ServiceAreaCode getServiceByServiceName(String serviceName);
}
