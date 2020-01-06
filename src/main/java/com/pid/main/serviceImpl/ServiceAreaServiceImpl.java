package com.pid.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pid.main.dto.ServiceAreaDTO;
import com.pid.main.model.ServiceAreaCode;
import com.pid.main.repository.ServiceAreaRepository;
import com.pid.main.service.ServiceAreaService;

@Service
public class ServiceAreaServiceImpl implements ServiceAreaService {

	@Autowired
	private ServiceAreaRepository serviceAreaRepository;

	@Override
	public List<ServiceAreaDTO> getAllServiceArea() {

		return convertModelEntityToDTO(serviceAreaRepository.findAll());
	}

	private List<ServiceAreaDTO> convertModelEntityToDTO(List<ServiceAreaCode> serviceAreaEntityList) {

		List<ServiceAreaDTO> serviceAreaDTOList = new ArrayList<ServiceAreaDTO>();

		if (serviceAreaEntityList != null && serviceAreaEntityList.size() > 0) {
			for (ServiceAreaCode serviceAreaCode : serviceAreaEntityList) {
				ServiceAreaDTO serviceAreaDTO = new ServiceAreaDTO(serviceAreaCode);
				serviceAreaDTOList.add(serviceAreaDTO);
			}
		}
		return serviceAreaDTOList;
	}
}
