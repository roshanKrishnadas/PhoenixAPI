package com.api.utils;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {
	
	
	private DateTimeUtil() {
		
	}
public static String getTimeWithDaysAgo(int months) {
	//return Instant.now().minus(months, ChronoUnit.MONTHS).toString();
	
	    return ZonedDateTime.now()
	            .minusMonths(months)
	            .toInstant()
	            .toString();
	
}
}
