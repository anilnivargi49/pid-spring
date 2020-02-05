package com.pid.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pid.main.dto.DeviceDTO;
import com.pid.main.dto.TemplateDTO;
import com.pid.main.service.DeviceService;

@RestController
@RequestMapping(value = "/device")
public class PIDDeviceController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping(value = "/{id}/template", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TemplateDTO> getAllTemplates(@PathVariable("id") String id) {

		return deviceService.getAllTemplates(Integer.parseInt(id));
	}

	@GetMapping("/list")
	public List<DeviceDTO> getAllDevices() {

		return deviceService.getAllDevices();
	}

}
