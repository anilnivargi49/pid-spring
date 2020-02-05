package com.pid.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pid.main.dto.MeasurementDTO;
import com.pid.main.model.Measurements;
import com.pid.main.repository.MeasurementsRepository;
import com.pid.main.service.MeasurementService;

@Service
public class MeasurementServiceImpl implements MeasurementService {

	@Autowired
	private MeasurementsRepository measurementsRepository;

	@Override
	public List<MeasurementDTO> getAllDeviceMeaseurements() {

		return convertModelToDTOList(measurementsRepository.findAll());

	}

	private List<MeasurementDTO> convertModelToDTOList(List<Measurements> measurementList) {

		List<MeasurementDTO> measurementDTOList = new ArrayList<>();
		for (Measurements measurement : measurementList) {
			MeasurementDTO measurementDTO = new MeasurementDTO(measurement);
			measurementDTOList.add(measurementDTO);
		}
		return measurementDTOList;
	}

}
