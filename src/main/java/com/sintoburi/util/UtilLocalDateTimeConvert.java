package com.sintoburi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilLocalDateTimeConvert {
	
	public static String formatter() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return now.format(formatter);
	}
	
}
