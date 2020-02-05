package com.pid.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pid.main.dto.MeasurementDTO;
import com.pid.main.service.MeasurementService;

@RestController
@RequestMapping(value = "/measurement")
public class MeasurementController {

	@Autowired
	private MeasurementService measurementService;

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MeasurementDTO> getAllDeviceMeaseurements() {

		return measurementService.getAllDeviceMeaseurements();
	}

}
