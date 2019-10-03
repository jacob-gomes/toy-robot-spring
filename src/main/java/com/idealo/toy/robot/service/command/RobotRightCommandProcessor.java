package com.idealo.toy.robot.service.command;

import org.springframework.stereotype.Component;

import com.idealo.toy.robot.service.model.RobotCoordinatesWithDirection;

@Component
public class RobotRightCommandProcessor extends RobotBaseCommandProcessor {
	
	@Override
	public void processCommand(RobotCoordinatesWithDirection currentCoordinatesWithDirection,
			StringBuffer reportMessage, String commandLine) throws Exception {

		validateIsRobotMising(currentCoordinatesWithDirection);
		
		currentCoordinatesWithDirection.setDirectionRelationShip(
				currentCoordinatesWithDirection.getDirectionRelationShip().getDirectiontoRight());
	}
}
