package com.pid.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pid.main.dto.MasterListDTO;
import com.pid.main.model.MasterList;
import com.pid.main.repository.MasterListRepository;
import com.pid.main.service.MasterListService;

@Service
public class MasterListServiceImpl implements MasterListService {

	@Autowired
	private MasterListRepository masterListRepository;

	@Override
	public List<MasterListDTO> getMasterListDetails() {

		List<MasterListDTO> masterListDTO = new ArrayList<>();
		List<MasterList> masterLists = (List<MasterList>) masterListRepository.findAll();

		convertEntityToDtoList(masterLists, masterListDTO);

		return masterListDTO;

	}

	private List<MasterListDTO> convertEntityToDtoList(List<MasterList> entityList, List<MasterListDTO> masterListDTO) {

		if (entityList != null && entityList.size() > 0) {
			for (MasterList masterList : entityList) {
				MasterListDTO masterDTO = new MasterListDTO();
				masterDTO.setId(masterList.getId());
				masterDTO.setPidReference(masterList.getPidReference().getPIDReference());
				masterDTO.setDeviceName(masterList.getPidDevice().getDeviceName());
				masterDTO.setDeviceFunction(masterList.getDeviceFunction().getDeviceFunction());
				masterDTO.setMeasurement(masterList.getMeasurement().getMeasurement());
				masterDTO.setDeviceTag(masterList.getDeviceTag());
				masterListDTO.add(masterDTO);
			}
		}
		return masterListDTO;
	}
}
