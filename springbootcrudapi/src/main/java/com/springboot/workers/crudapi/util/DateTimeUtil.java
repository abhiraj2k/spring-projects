package com.springboot.workers.crudapi.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		return format.format(new Date());
	}
}