package com.idealo.toy.robot.enumarators;

public enum RobotCommands {
	PLACE("PLACE"),MOVE("MOVE"),LEFT("LEFT"),RIGHT("RIGHT"),REPORT("REPORT");
	
	private String command;
	
	RobotCommands(String command){
		this.command = command;
	}
	
	public String getCommand() {
		return this.command;
	}
}
