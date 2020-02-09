package com.pid.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pid.main.dto.MasterListDTO;
import com.pid.main.model.MasterList;
import com.pid.main.model.PIDDevice;
import com.pid.main.repository.DeviceFunctionRepository;
import com.pid.main.repository.DeviceRepository;
import com.pid.main.repository.MasterListRepository;
import com.pid.main.repository.MeasurementsRepository;
import com.pid.main.repository.PIDReferenceRepository;
import com.pid.main.repository.ServiceAreaCodeRepository;
import com.pid.main.service.MasterListService;

@Service
public class MasterListServiceImpl implements MasterListService {

	@Autowired
	private MasterListRepository masterListRepository;

	@Autowired
	private DeviceRepository deviceRepository;

	@Autowired
	private PIDReferenceRepository pidReferenceRepository;

	@Autowired
	private ServiceAreaCodeRepository serviceAreaCodeRepository;

	@Autowired
	private DeviceFunctionRepository deviceFunctionRepository;

	@Autowired
	private MeasurementsRepository measurementsRepository;

	@Override
	public List<MasterListDTO> getMasterListDetails() {

		List<MasterListDTO> masterListDTO = new ArrayList<>();
		List<MasterList> masterLists = (List<MasterList>) masterListRepository.findAll();

		// convertEntityToDtoList(masterLists, masterListDTO);

		converMasterListEntityToDTOList(masterLists, masterListDTO);

		return masterListDTO;

	}

	@Override
	public List<MasterListDTO> createOrUpdateMasterList(MasterListDTO masterListDTO) {

		MasterList masterList = convertDTOtoEntity(masterListDTO);
		masterListRepository.save(masterList);
		List<MasterListDTO> masterListDTOList = new ArrayList<>();
		List<MasterList> masterLists = (List<MasterList>) masterListRepository.findAll();

		convertEntityToDtoList(masterLists, masterListDTOList);

		return masterListDTOList;
	}

	private List<MasterListDTO> converMasterListEntityToDTOList(List<MasterList> entityList,
			List<MasterListDTO> masterListDTO) {

		if (entityList != null && entityList.size() > 0) {
			for (MasterList masterList : entityList) {
				MasterListDTO masterDTO = new MasterListDTO();
				masterDTO.setId(masterList.getId());
				masterDTO.setServiceArea(masterList.getServiceAreaCode().getServiceArea());
				masterDTO.setServiceAreaListFromEntity(serviceAreaCodeRepository.findAll());
				masterDTO.setPidReference(masterList.getPidReference().getPIDReference());
				masterDTO.setPidReferenceListFromEntity(pidReferenceRepository.findAll());
				masterDTO.setDeviceName(masterList.getPidDevice().getDeviceName());
				masterDTO.setDeviceListFromEntity(deviceRepository.findAll());
				masterDTO.setDeviceFunction(masterList.getDeviceFunction().getDeviceFunction());
				masterDTO.setDeviceFunctionListFromEntity(
						deviceFunctionRepository.findAllByDevice(masterList.getPidDevice()));
				masterDTO.setMeasurement(masterList.getMeasurement().getMeasurement());
				masterDTO.setMeasurementListFromEntity(
						measurementsRepository.findAllByFunction(masterList.getDeviceFunction()));
				masterDTO.setDeviceTag(masterList.getDeviceTag());
				masterDTO.setIsaCode(masterList.getIsaCode());
				masterDTO.setLoopNo(masterList.getLoopNo());
				masterDTO.setNoOfWires(masterList.getNoOfWires());
				masterListDTO.add(masterDTO);
			}
		}
		return masterListDTO;
	}

	private List<MasterListDTO> convertEntityToDtoList(List<MasterList> entityList, List<MasterListDTO> masterListDTO) {

		if (entityList != null && entityList.size() > 0) {
			for (MasterList masterList : entityList) {
				MasterListDTO masterDTO = new MasterListDTO();
				masterDTO.setId(masterList.getId());
				masterDTO.setServiceArea(masterList.getServiceAreaCode().getServiceArea());
				masterDTO.setPidReference(masterList.getPidReference().getPIDReference());
				masterDTO.setDeviceName(masterList.getPidDevice().getDeviceName());
				masterDTO.setDeviceFunction(masterList.getDeviceFunction().getDeviceFunction());
				masterDTO.setMeasurement(masterList.getMeasurement().getMeasurement());
				masterDTO.setDeviceTag(masterList.getDeviceTag());
				masterDTO.setIsaCode(masterList.getIsaCode());
				masterDTO.setLoopNo(masterList.getLoopNo());
				masterDTO.setNoOfWires(masterList.getNoOfWires());
				masterListDTO.add(masterDTO);
			}
		}
		return masterListDTO;
	}

	private MasterList convertDTOtoEntity(MasterListDTO masterListDTO) {

		MasterList masterList = new MasterList();
		if (masterListDTO.getId() > 0) {
			masterList.setId(masterListDTO.getId());
		}
		masterList.setPidReference(
				pidReferenceRepository.getReferenceById(Integer.parseInt(masterListDTO.getPidReference())));
		if (masterListDTO.getDeviceName() != null) {
			PIDDevice pidDevice = deviceRepository.getDeviceById(Integer.parseInt(masterListDTO.getDeviceName()));
			masterList.setPidDevice(pidDevice);
		}
		masterList.setServiceAreaCode(
				serviceAreaCodeRepository.getServiceById(Integer.parseInt(masterListDTO.getServiceArea())));

		masterList.setDeviceFunction(deviceFunctionRepository.getDevFunctionById(masterListDTO.getDeviceFunctionId()));
		masterList.setMeasurement(measurementsRepository.getMeasurementById(masterListDTO.getMeasurementId()));

		masterList.setIsaCode(masterListDTO.getIsaCode());
		masterList.setLoopNo(masterListDTO.getLoopNo());
		masterList.setNoOfWires(masterListDTO.getNoOfWires());
		masterList.setDeviceTag(formatDeviceTag(masterList));
		return masterList;
	}

	private String formatDeviceTag(MasterList masterList) {
		Integer serviceAreaCode = masterList.getServiceAreaCode().getAreaCode();
		Integer loopNo = masterList.getLoopNo();
		String isaCode = masterList.getIsaCode();
		Integer noOfWires = masterList.getNoOfWires();

		return serviceAreaCode + "_" + isaCode + "_" + noOfWires + "W" + loopNo;
	}
}
