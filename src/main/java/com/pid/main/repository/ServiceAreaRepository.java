package com.pid.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pid.main.model.ServiceAreaCode;

public interface ServiceAreaRepository extends JpaRepository<ServiceAreaCode, Integer> {

}
