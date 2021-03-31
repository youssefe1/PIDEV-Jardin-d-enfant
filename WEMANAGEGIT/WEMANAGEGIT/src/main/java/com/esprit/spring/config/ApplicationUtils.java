package com.esprit.spring.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ApplicationUtils {

	private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");

	public static String getTime() {
		return dateTimeFormatter.format(LocalDateTime.now()); //  13:46 26-07-2020
	}
	
	public static SimpleDateFormat getDate() throws ParseException {
		//return new SimpleDateFormat("HH:mm dd-MM-yyyy").parse(dateTimeFormatter.format(LocalDateTime.now()));
		Date date = new Date(); // This object contains the current date value
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return formatter;

	}


}
