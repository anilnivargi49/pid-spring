package com.pid.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pid.main.dto.PIDReferenceDTO;
import com.pid.main.service.PIDReferenceService;

@RestController
@RequestMapping(value = "/pidreference")
public class PIDReferenceController {

	@Autowired
	private PIDReferenceService pidReferenceService;

	@GetMapping("/list")
	public List<PIDReferenceDTO> getAllPIDReferences() {

		return pidReferenceService.getPIDReferenceList();
	}
}
