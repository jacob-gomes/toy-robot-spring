package com.idealo.toy.robot.enumarators;

import java.util.stream.Stream;

import com.idealo.toy.robot.service.model.RobotCoordinates;
import com.idealo.toy.robot.service.model.RobotDirectionRelationShip;

public enum RobotsDirections {
	NORTH("NORTH",0,1),
	EAST("EAST",1,0),
	SOUTH("SOUTH",0,-1),
	WEST("WEST",-1,0);
	
	private String directionName;
	
	private RobotCoordinates nextMoveAdditionCoordinates;
	
	private RobotsDirections(String directionName, int xCoordinates, int yCoordinates) {
		this.directionName= directionName;
		this.nextMoveAdditionCoordinates = new RobotCoordinates(xCoordinates,yCoordinates);
	}
	
	public String getDirectionName() {
		return this.directionName;
	}
	
	public RobotCoordinates getRobotCoordinates() {
		return this.nextMoveAdditionCoordinates;
	}
	
	public static Stream<RobotsDirections> stream() {
        return Stream.of(RobotsDirections.values()); 
    }
	
	public static void populateDirection(RobotDirectionRelationShip directionRelationShip, String directionName) {
		RobotsDirections.stream().forEach(directionObject ->{
			RobotsDirections robotDirection = (RobotsDirections)directionObject;
			if(robotDirection.getDirectionName().equals(directionName)) {
				directionRelationShip.setRobotDirection(robotDirection);
			}
		});
	}
}
