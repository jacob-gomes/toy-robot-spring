package com.idealo.toy.robot.service.model;

import com.idealo.toy.robot.enumarators.RobotsDirections;

public class RobotDirectionRelationShip{
	
	private RobotDirectionRelationShip directionToLeft;
	
	private RobotsDirections robotDirection;
	
	private RobotDirectionRelationShip directionToRight;
		

	public static RobotDirectionRelationShip getDefaultDirection() {
		RobotDirectionRelationShip northDirectionRelationShip = new RobotDirectionRelationShip(RobotsDirections.NORTH);
		RobotDirectionRelationShip eastDirectionRelationShip = new RobotDirectionRelationShip(RobotsDirections.EAST);
		RobotDirectionRelationShip southDirectionRelationShip = new RobotDirectionRelationShip(RobotsDirections.SOUTH);
		RobotDirectionRelationShip westDirectionRelationShip = new RobotDirectionRelationShip(RobotsDirections.WEST);
		
		northDirectionRelationShip.setDirectionToLeftAndRight(westDirectionRelationShip,eastDirectionRelationShip);
		eastDirectionRelationShip.setDirectionToLeftAndRight(northDirectionRelationShip, southDirectionRelationShip);
		southDirectionRelationShip.setDirectionToLeftAndRight(eastDirectionRelationShip, westDirectionRelationShip);
		westDirectionRelationShip.setDirectionToLeftAndRight(southDirectionRelationShip, northDirectionRelationShip);
		
		return northDirectionRelationShip;
	}

	
	public RobotDirectionRelationShip getDirection(String directionName) throws Exception {
		RobotDirectionRelationShip temporaryDirectionRelationShip = new RobotDirectionRelationShip();
		RobotsDirections.populateDirection(temporaryDirectionRelationShip, directionName);
		if(null != temporaryDirectionRelationShip.getRobotDirection()) {
			RobotDirectionRelationShip finalDirection = this;
			while(!finalDirection.getRobotDirection()
					.equals(temporaryDirectionRelationShip.getRobotDirection())) {
				finalDirection = finalDirection.getDirectiontoRight();
			}
			return finalDirection;
		}
		throw new Exception("Improper direction");
	}
	
	public RobotDirectionRelationShip() {}
	
	private RobotDirectionRelationShip(RobotsDirections robotDirection){
		this.robotDirection = robotDirection;
	}
	
	private void setDirectionToLeftAndRight(RobotDirectionRelationShip directionToLeft,RobotDirectionRelationShip directionToRight) {
		this.directionToLeft = directionToLeft;
		this.directionToRight = directionToRight;
	}	
	/**
	 * @return the directionToLeft
	 */
	public RobotDirectionRelationShip getDirectionToLeft() {
		return directionToLeft;
	}

	/**
	 * @return the directiontoRight
	 */
	public RobotDirectionRelationShip getDirectiontoRight() {
		return directionToRight;
	}
	
	/**
	 * @return the robotDirection
	 */
	public RobotsDirections getRobotDirection() {
		return robotDirection;
	}

	public void setRobotDirection(RobotsDirections robotsDirections) {
		this.robotDirection = robotsDirections;
	}
	
}