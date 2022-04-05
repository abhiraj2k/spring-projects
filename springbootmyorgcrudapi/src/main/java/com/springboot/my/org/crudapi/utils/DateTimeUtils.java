package com.springboot.my.org.crudapi.utils;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtils {

	public static Date getUtilDate(LocalDateTime localDate) {
		if(localDate == null) {
			return null;
		}
		return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	
}