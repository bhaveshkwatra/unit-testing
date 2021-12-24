package com.nagarro.nagp.assignment.unit.testing.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class HelperUtils {

	private HelperUtils() {}

	public static boolean isBuySellValid() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		return !isWeekend(currentDateTime) && isWorkingHours(currentDateTime);
	}
	
	private static boolean isWeekend(LocalDateTime currentDateTime) {
		DayOfWeek day = currentDateTime.getDayOfWeek();
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
	}
	
	private static boolean isWorkingHours(LocalDateTime currentDateTime) {
		return currentDateTime.getHour() >= 9 && currentDateTime.getHour() < 20;
	}

}
