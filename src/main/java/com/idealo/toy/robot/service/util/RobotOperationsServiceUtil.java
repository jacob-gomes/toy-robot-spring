package com.idealo.toy.robot.service.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RobotOperationsServiceUtil {
	
	@Value("${idealo.table.size}")
	private Integer idealoTableSize;
	
	public boolean isCoordinateOnTable (Integer xCoordinates, Integer yCoordinates) {
		if(xCoordinates > (idealoTableSize - 1) || xCoordinates < 0 ||
				yCoordinates > (idealoTableSize - 1) || yCoordinates < 0) {
			return false;
		}
		return true;
	}
}
