package com.pid.main.service;

import java.util.List;

import com.pid.main.dto.DeviceDTO;
import com.pid.main.dto.TemplateDTO;

public interface DeviceService {

	public List<TemplateDTO> getAllTemplates(Integer id);

	public List<DeviceDTO> getAllDevices();
}
