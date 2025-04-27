package com.ecommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CommonUtils {
	
	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	
private static Properties configProperties;
protected static Properties properties;
private static String filePath = "./src/test/resources/config.properties";
	
	public static Properties getProperties() throws IOException
	{
		configProperties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "./src/test/resources/config.properties");
		configProperties.load(fileInputStream);
		return configProperties;
	}
	
	public static Properties loadProperties() throws FileNotFoundException {
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(filePath);
		try {
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	public static int getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
	
	public static LocalDate getCurrentDate() {
	    try {
	        return LocalDate.now();
	    } catch (Exception e) {
	        logger.error("An error occurred while getting the current date", e);
	        return null;
	    }
	}

	

	public static int getCurrentDay() {
		try {
			LocalDate date = LocalDate.now();
			return date.getDayOfMonth();	
		} catch (Exception e) {
			logger.error("An error occurred while getting the current day", e);
	        return 0;
		}
}
	
	public static int getCurrentMonth() {
		
		try {
			LocalDate date = LocalDate.now();
			return date.getMonthValue();
		} catch (Exception e) {
			logger.error("An error occurred while getting the current month", e);
			return 0;
		}
		
	}

	public static int getCurrentYear() {
		try {
			LocalDate date = LocalDate.now();
			return date.getYear();	
		} catch (Exception e) {
			logger.error("An error occurred while getting the current year", e);
			return 0;
		}
		
	}

	public static String getCurrentMonthYear() {
		try {
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM YYYY");
			 return date.format(formatter);
		} catch (Exception e) {
			logger.error("An error occurred while getting the current month and year", e);
			return null;
		}
		
		}


	public static int getFutureDay() {
		try {
			LocalDate date = LocalDate.now().plusDays(Constants.TWO_WEEKS);
			return date.getDayOfMonth();
		} catch (Exception e) {
			logger.error("An error occurred while getting the future day", e);
			return 0;
		}
		}
	public static String getFutureMonthYear() {
		try {
			LocalDate date = LocalDate.now().plusDays(Constants.TWO_WEEKS);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
			return date.format(formatter);
		} catch (Exception e) {
			logger.error("An error occurred while getting the future month and year", e);
			return null;
		}
		

	
		
	}
	public static String getCurrentDateTime()
	{
		try {
			 String dateName = new SimpleDateFormat("yyyy-MMMM-dd_hhmmss").format(new Date());
			 return dateName;	
		} catch (Exception e) {
			logger.error("An error occurred while getting the current date and tine", e);
			return null;
		}
		
		}
	
	
	

}
