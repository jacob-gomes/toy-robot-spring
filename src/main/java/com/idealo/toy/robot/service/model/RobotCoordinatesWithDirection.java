package com.idealo.toy.robot.service.model;

public class RobotCoordinatesWithDirection extends RobotCoordinates {
	private RobotDirectionRelationShip directionRelationShip;
	

	/**
	 * @return the directionRelationShip
	 */
	public RobotDirectionRelationShip getDirectionRelationShip() {
		return directionRelationShip;
	}

	/**
	 * @param directionRelationShip the directionRelationShip to set
	 */
	public void setDirectionRelationShip(RobotDirectionRelationShip directionRelationShip) {
		this.directionRelationShip = directionRelationShip;
	}

	
}
