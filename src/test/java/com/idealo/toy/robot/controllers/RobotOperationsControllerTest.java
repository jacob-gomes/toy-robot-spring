package com.idealo.toy.robot.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotOperationsControllerTest {

	@Autowired
	private RobotOperationsController robotOperationsController;

	@Test
	public void testCase1() throws Exception {
		String requestBody = "PLACE 0,0,NORTH\r\n" + 
				"MOVE\r\n" + 
				"REPORT";

		ResponseEntity<String> requestEntity = robotOperationsController.robotOperations(requestBody);
		String responseBody = requestEntity.getBody();
		assertEquals("0,1,NORTH",responseBody);
	}

	@Test
	public void testCase2() throws Exception {
		String requestBody = "PLACE 0,0,NORTH\r\n" + 
				"LEFT\r\n" + 
				"REPORT";

		ResponseEntity<String> requestEntity = robotOperationsController.robotOperations(requestBody);
		String responseBody = requestEntity.getBody();
		assertEquals("0,0,WEST",responseBody);
	}

	@Test
	public void testCase3() throws Exception {
		String requestBody = "PLACE 1,2,EAST\r\n" + 
				"MOVE\r\n" + 
				"MOVE\r\n" + 
				"LEFT\r\n" + 
				"MOVE\r\n" + 
				"REPORT";

		ResponseEntity<String> requestEntity = robotOperationsController.robotOperations(requestBody);
		String responseBody = requestEntity.getBody();
		assertEquals("3,3,NORTH",responseBody);
	}

	@Test
	public void testCase4(){
		String requestBody = "MOVE";
		try {
			robotOperationsController.robotOperations(requestBody);

		}catch(Exception e) {
			assertEquals("ROBOT MISSING",e.getMessage());
		}
	}
}
