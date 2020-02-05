package com.pid.main.service;

import java.util.List;

import com.pid.main.dto.DeviceFunctionDTO;

public interface DeviceFunctionService {

	public List<DeviceFunctionDTO> getAllDeviceFunctions();

	public List<DeviceFunctionDTO> getAllDeviceFunctionsByDeviceId(Integer id);

}
