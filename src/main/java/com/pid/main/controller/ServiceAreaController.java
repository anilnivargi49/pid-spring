package com.pid.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pid.main.dto.ServiceAreaDTO;
import com.pid.main.service.ServiceAreaService;

@RestController
@RequestMapping(value = "/servicearea")
public class ServiceAreaController {

	@Autowired
	private ServiceAreaService serviceAreaService;

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ServiceAreaDTO> getAllServiceArea() {

		return serviceAreaService.getAllServiceArea();
	}

}
