package com.pid.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pid.main.dto.MasterListDTO;
import com.pid.main.service.MasterListService;

@RestController
@RequestMapping(value = "/masterlist")
public class MasterListController {

	@Autowired
	private MasterListService masterListService;

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MasterListDTO> home() {

		return masterListService.getMasterListDetails();
	}

	@PostMapping(value = "/createOrUpdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MasterListDTO> createOrUpdate() {

		return masterListService.getMasterListDetails();
	}

}
