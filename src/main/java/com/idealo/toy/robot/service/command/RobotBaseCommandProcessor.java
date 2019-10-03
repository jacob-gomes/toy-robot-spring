package com.idealo.toy.robot.service.command;

import org.springframework.stereotype.Component;

import com.idealo.toy.robot.service.model.RobotCoordinatesWithDirection;

@Component
public class RobotBaseCommandProcessor {
	public void processCommand(RobotCoordinatesWithDirection currentCoordinatesWithDirection,
			StringBuffer reportMessage, String commandLine) throws Exception {
		throw new UnsupportedOperationException("Invalid command");
	}
	
	protected void validateIsRobotMising(RobotCoordinatesWithDirection currentCoordinatesWithDirection) throws Exception {
		if(null == currentCoordinatesWithDirection.getxCoordinates() 
				|| null == currentCoordinatesWithDirection.getyCoordinates() ) {
			throw new Exception("ROBOT MISSING");
		}
	}
}
