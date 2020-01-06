package com.pid.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pid.main.dto.PIDReferenceDTO;
import com.pid.main.model.PIDReference;
import com.pid.main.repository.PIDReferenceRepository;
import com.pid.main.service.PIDReferenceService;

@Service
public class PIDReferenceServiceImpl implements PIDReferenceService {

	@Autowired
	private PIDReferenceRepository pIDReferenceRepository;

	@Override
	public List<PIDReferenceDTO> getPIDReferenceList() {
		List<PIDReferenceDTO> pidRefList = new ArrayList<>();
		List<PIDReference> pidRefENtityList = pIDReferenceRepository.findAll();
		convertModelTODTO(pidRefENtityList, pidRefList);
		return pidRefList;
	}

	private List<PIDReferenceDTO> convertModelTODTO(List<PIDReference> pidRefEntityList,
			List<PIDReferenceDTO> pidRefDTOList) {

		if (pidRefEntityList != null && pidRefEntityList.size() > 0) {
			for (PIDReference pidRef : pidRefEntityList) {
				PIDReferenceDTO pidRefDTO = new PIDReferenceDTO(pidRef);
				pidRefDTOList.add(pidRefDTO);
			}
		}
		return pidRefDTOList;
	}

}
