package com.idealo.toy.robot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.idealo.toy.robot.service.RobotOperationsService;

/**
 * 
 * @author Jacob
 *
 */
@RestController
@Component
public class RobotOperationsController {
	
	@Autowired
	private RobotOperationsService robotOperationsService;

	@PostMapping(value = "/",
			produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> robotOperations(			
			@RequestBody String encodedCommandLines) throws Exception {
		
		String responseBody = robotOperationsService.doOperations(encodedCommandLines);
		
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
}
