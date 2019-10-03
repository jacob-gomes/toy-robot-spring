package com.idealo.toy.robot.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idealo.toy.robot.service.model.RobotCoordinates;
import com.idealo.toy.robot.service.model.RobotCoordinatesWithDirection;
import com.idealo.toy.robot.service.model.RobotDirectionRelationShip;
import com.idealo.toy.robot.service.util.RobotOperationsServiceUtil;

@Component
public class RobotMoveCommandProcessor extends RobotBaseCommandProcessor {
	
	@Autowired
	private RobotOperationsServiceUtil robotOperationsServiceUtil;
	
	@Override
	public void processCommand(RobotCoordinatesWithDirection currentCoordinatesWithDirection,
			StringBuffer reportMessage, String commandLine) throws Exception {
		
		validateIsRobotMising(currentCoordinatesWithDirection);
		
		RobotCoordinatesWithDirection nextMoveCoordinatesWithDirection 
			= calculateNextMoveCoordinatesWithDirection(currentCoordinatesWithDirection);
		
		boolean isCoordinateValid = robotOperationsServiceUtil.isCoordinateOnTable(
				nextMoveCoordinatesWithDirection.getxCoordinates(),
						nextMoveCoordinatesWithDirection.getyCoordinates());
		
		if(isCoordinateValid) {
			currentCoordinatesWithDirection.setxCoordinates(nextMoveCoordinatesWithDirection.getxCoordinates());
			currentCoordinatesWithDirection.setyCoordinates(nextMoveCoordinatesWithDirection.getyCoordinates());
		}
	}

	private RobotCoordinatesWithDirection calculateNextMoveCoordinatesWithDirection(
			RobotCoordinatesWithDirection currentCoordinatesWithDirection) {
		
		RobotCoordinatesWithDirection nextMoveCoordinatesWithDirection
			= new RobotCoordinatesWithDirection();
		
		RobotDirectionRelationShip  robotDirectionRelationShip = 
				currentCoordinatesWithDirection.getDirectionRelationShip();
		RobotCoordinates deltaRobotCoordinate =
				robotDirectionRelationShip.getRobotDirection().getRobotCoordinates();
		
		nextMoveCoordinatesWithDirection.setxCoordinates(
				currentCoordinatesWithDirection.getxCoordinates() + deltaRobotCoordinate.getxCoordinates());
		
		nextMoveCoordinatesWithDirection.setyCoordinates(
				currentCoordinatesWithDirection.getyCoordinates() + deltaRobotCoordinate.getyCoordinates());
		
		
		return nextMoveCoordinatesWithDirection;
	}
}
