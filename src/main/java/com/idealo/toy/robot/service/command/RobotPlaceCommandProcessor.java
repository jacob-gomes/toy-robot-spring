package com.idealo.toy.robot.service.command;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idealo.toy.robot.service.model.RobotCoordinatesWithDirection;
import com.idealo.toy.robot.service.model.RobotDirectionRelationShip;
import com.idealo.toy.robot.service.util.RobotOperationsServiceUtil;

@Component
public class RobotPlaceCommandProcessor extends RobotBaseCommandProcessor {
	
	
	private RobotDirectionRelationShip robotDirectionRelationShip;
	
	@Autowired
	private RobotOperationsServiceUtil robotOperationsServiceUtil;
	
	@PostConstruct
	public void postConstructInit() {
		robotDirectionRelationShip = RobotDirectionRelationShip.getDefaultDirection();
	}
	
	@Override
	public void processCommand(RobotCoordinatesWithDirection currentCoordinatesWithDirection,
			StringBuffer reportMessage, String commandLine) throws Exception {
		try {
			String[] commandParts = commandLine.split(" ");
			String[] arguments = commandParts[1].split(",");
			Integer xCoordinates = Integer.parseInt(arguments[0]);
			Integer yCoordinates = Integer.parseInt(arguments[1]);
			String directionName = arguments[2];
			
			if(!robotOperationsServiceUtil.isCoordinateOnTable(xCoordinates,yCoordinates)) {
				throw new Exception("Please place the Robot on the table");
			}
			
			RobotDirectionRelationShip  robotDirectionRelationShipTemp
				= robotDirectionRelationShip.getDirection(directionName);
			
			currentCoordinatesWithDirection.setxCoordinates(xCoordinates);
			currentCoordinatesWithDirection.setyCoordinates(yCoordinates);
			currentCoordinatesWithDirection.setDirectionRelationShip(robotDirectionRelationShipTemp);
			
		}catch(NumberFormatException e) {
			throw new Exception("Enter proper Coordinates (PLACE X,Y,DIRECTION)");
		}
	}
}
