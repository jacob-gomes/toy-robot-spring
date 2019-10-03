package com.idealo.toy.robot.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idealo.toy.robot.enumarators.RobotCommands;

@Component
public class RobotCommandFactory {
	
	@Autowired
	private RobotBaseCommandProcessor robotBaseCommandProcessor;
	
	@Autowired
	private RobotLeftCommandProcessor robotLeftCommandProcessor;
	
	@Autowired
	private RobotMoveCommandProcessor robotMoveCommandProcessor;
	
	@Autowired
	private RobotPlaceCommandProcessor robotPlaceCommandProcessor;
	
	@Autowired
	private RobotReportCommandProcessor robotReportCommandProcessor;
	
	@Autowired
	private RobotRightCommandProcessor robotRightCommandProcessor;
	
	/**
	 * A factory class to generate suitable implementation class to execute the process
	 * @param commandLine
	 * @return
	 */
	public RobotBaseCommandProcessor fetchRobotCommandImpl(String commandLine){
		if(null != commandLine) {
			if(commandLine.startsWith(RobotCommands.PLACE.getCommand()) ) {
				return robotPlaceCommandProcessor;
			}else if(commandLine.startsWith(RobotCommands.MOVE.getCommand())) {
				return robotMoveCommandProcessor;
			}else if(commandLine.startsWith(RobotCommands.LEFT.getCommand())) {
				return robotLeftCommandProcessor;
			}else if(commandLine.startsWith(RobotCommands.RIGHT.getCommand())) {
				return robotRightCommandProcessor;
			}else if(commandLine.startsWith(RobotCommands.REPORT.getCommand())) {
				return robotReportCommandProcessor;
			}
		}
		return robotBaseCommandProcessor;
	}

}
