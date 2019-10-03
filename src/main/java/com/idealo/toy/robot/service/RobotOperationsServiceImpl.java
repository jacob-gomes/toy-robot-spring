package com.idealo.toy.robot.service;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.idealo.toy.robot.service.command.RobotBaseCommandProcessor;
import com.idealo.toy.robot.service.command.RobotCommandFactory;
import com.idealo.toy.robot.service.model.RobotCoordinatesWithDirection;

@Component
public class RobotOperationsServiceImpl implements RobotOperationsService {

	@Autowired
	private RobotCommandFactory robotCommandFactory;
	
	@Override
	public String doOperations(String encodedCommandLines) throws Exception {
		if(!StringUtils.isEmpty(encodedCommandLines)) {
			
			String decodedCommandLines = URLDecoder.decode(encodedCommandLines,"UTF-8");
			decodedCommandLines = decodedCommandLines.replace("=", "");
			decodedCommandLines = decodedCommandLines.replace("\r", "");
			
			RobotCoordinatesWithDirection currentCoordinatesWithDirection = 
					new RobotCoordinatesWithDirection();
			StringBuffer responseMessageBuffer = new StringBuffer();
					
			String[] commandLinesArray = decodedCommandLines.split("\n");
			
			for(String commandLine : commandLinesArray) {
				RobotBaseCommandProcessor robotCommand = robotCommandFactory.fetchRobotCommandImpl(commandLine);
				robotCommand.processCommand(currentCoordinatesWithDirection, responseMessageBuffer, commandLine);
			}
			
			return  responseMessageBuffer.toString();
		}
		return null;
	}

}
