package com.idealo.toy.robot.service.command;

import org.springframework.stereotype.Component;

import com.idealo.toy.robot.service.model.RobotCoordinatesWithDirection;

@Component
public class RobotReportCommandProcessor extends RobotBaseCommandProcessor {
	
	@Override
	public void processCommand(RobotCoordinatesWithDirection currentCoordinatesWithDirection,
			StringBuffer reportMessage, String commandLine) throws Exception {

		validateIsRobotMising(currentCoordinatesWithDirection);
		
		reportMessage.append(currentCoordinatesWithDirection.getxCoordinates());
		reportMessage.append(",");
		reportMessage.append(currentCoordinatesWithDirection.getyCoordinates());
		reportMessage.append(",");
		reportMessage.append(currentCoordinatesWithDirection.getDirectionRelationShip().getRobotDirection().getDirectionName());
	}
}
