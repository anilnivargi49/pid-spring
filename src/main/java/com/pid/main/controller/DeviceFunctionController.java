package com.pid.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pid.main.dto.DeviceFunctionDTO;
import com.pid.main.service.DeviceFunctionService;

@RestController
@RequestMapping(value = "/device-function")
public class DeviceFunctionController {

	@Autowired
	private DeviceFunctionService deviceFunctionService;

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeviceFunctionDTO> getAllDeviceFunctions() {

		return deviceFunctionService.getAllDeviceFunctions();
	}

	@GetMapping(value = "/device-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeviceFunctionDTO> getAllDeviceFunctionsByDeviceId(@PathVariable(name = "id") Integer deviceId) {

		return deviceFunctionService.getAllDeviceFunctionsByDeviceId(deviceId);
	}

}
