package com.idealo.toy.robot.service.model;

public class RobotCoordinates {
	private Integer xCoordinates;
	
	private Integer yCoordinates;

	public RobotCoordinates() {}
	
	public RobotCoordinates(Integer xCoordinates, Integer yCoordinates) {
		this.xCoordinates = xCoordinates;
		this.yCoordinates = yCoordinates;
	}

	/**
	 * @return the xCoordinates
	 */
	public Integer getxCoordinates() {
		return xCoordinates;
	}

	/**
	 * @param xCoordinates the xCoordinates to set
	 */
	public void setxCoordinates(Integer xCoordinates) {
		this.xCoordinates = xCoordinates;
	}

	/**
	 * @return the yCoordinates
	 */
	public Integer getyCoordinates() {
		return yCoordinates;
	}

	/**
	 * @param yCoordinates the yCoordinates to set
	 */
	public void setyCoordinates(Integer yCoordinates) {
		this.yCoordinates = yCoordinates;
	}
	

	
}
