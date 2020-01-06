package com.pid.main.serviceImpl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pid.main.Util.TemplateUtil;
import com.pid.main.dto.DeviceDTO;
import com.pid.main.dto.TemplateDTO;
import com.pid.main.model.DeviceTemplates;
import com.pid.main.model.MasterList;
import com.pid.main.model.PIDDevice;
import com.pid.main.repository.DeviceRepository;
import com.pid.main.repository.DeviceTemplateRepository;
import com.pid.main.repository.MasterListRepository;
import com.pid.main.service.DeviceService;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private MasterListRepository masterListRepository;

	@Autowired
	private DeviceTemplateRepository deviceTemplateRepository;

	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public List<TemplateDTO> getAllTemplates(Integer id) {

		List<TemplateDTO> templateList = null;
		List<MasterList> masterList = masterListRepository.getAlltemplatesByDeviceId(id);
		templateList = setDynamicTemplateValues(masterList);
		return templateList;
	}

	@Override
	public List<DeviceDTO> getAllDevices() {
		return (convertModelEntityToDTO(deviceRepository.findAll()));
	}

	private List<TemplateDTO> setDynamicTemplateValues(List<MasterList> masterList) {

		List<TemplateDTO> templateDTOList = new ArrayList<>();
		if (masterList != null && masterList.size() > 0) {
			for (MasterList list : masterList) {
				TemplateDTO templateDTO = processTemplate(list);
				templateDTOList.add(templateDTO);
			}
		}
		return templateDTOList;
	}

	private TemplateDTO processTemplate(MasterList masterList) {

		Template template = null;
		DeviceTemplates divTemplate = deviceTemplateRepository
				.getDeviceTemplateByDeviceId(masterList.getPidDevice().getId());

		String templateContent = divTemplate.getTemplateContent();

		try {
			template = new Template("tmp1", templateContent, TemplateUtil.getFreemarkerConfig());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, String> templateValueMap = new HashMap<>();
		templateValueMap.put("pid_ref", masterList.getPidReference().getPIDReference());
		templateValueMap.put("loop_no", masterList.getLoopNo().toString());
		templateValueMap.put("service_area", masterList.getServiceAreaCode().getServiceArea());
		templateValueMap.put("device", masterList.getPidDevice().getDeviceName());
		templateValueMap.put("functionality", masterList.getDeviceFunction().getDeviceFunction());
		templateValueMap.put("measurement", masterList.getMeasurement().getMeasurement());

		StringWriter stringWriter = new StringWriter();
		try {
			template.process(templateValueMap, stringWriter);
		} catch (TemplateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new TemplateDTO("template", stringWriter.toString());
	}

	private List<DeviceDTO> convertModelEntityToDTO(List<PIDDevice> deviceList) {

		List<DeviceDTO> deviceListDTO = new ArrayList<>();
		if (deviceList != null && deviceList.size() > 0) {
			for (PIDDevice pidDevice : deviceList) {
				DeviceDTO deviceDTO = new DeviceDTO(pidDevice);
				deviceListDTO.add(deviceDTO);
			}
		}
		return deviceListDTO;
	}

}
