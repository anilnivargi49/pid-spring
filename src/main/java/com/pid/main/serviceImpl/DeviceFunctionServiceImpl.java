package com.pid.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pid.main.dto.DeviceFunctionDTO;
import com.pid.main.model.DeviceFunction;
import com.pid.main.repository.DeviceFunctionRepository;
import com.pid.main.service.DeviceFunctionService;

@Service
public class DeviceFunctionServiceImpl implements DeviceFunctionService {

	@Autowired
	private DeviceFunctionRepository deviceFunctionRepository;

	@Override
	public List<DeviceFunctionDTO> getAllDeviceFunctions() {

		return convertEntityDataToDTO(deviceFunctionRepository.findAll());
	}

	private List<DeviceFunctionDTO> convertEntityDataToDTO(List<DeviceFunction> deviceFunctionList) {

		List<DeviceFunctionDTO> deviceFunctionDTOList = new ArrayList<>();
		for (DeviceFunction deviceFunction : deviceFunctionList) {
			DeviceFunctionDTO deviceFunctionDTO = new DeviceFunctionDTO(deviceFunction);
			deviceFunctionDTOList.add(deviceFunctionDTO);
		}
		return deviceFunctionDTOList;
	}

	@Override
	public List<DeviceFunctionDTO> getAllDeviceFunctionsByDeviceId(Integer id) {

		return convertEntityDataToDTO(deviceFunctionRepository.findAllByDeviceId(id));
	}

}
