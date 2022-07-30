package com.i2i.intern.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTimeTest {

	public static Logger logger = LogManager.getLogger(Log4jTimeTest.class);
	public static LocalDateTime time;
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");;

	public static void main(String[] args) {

		while (true) {
			try {

				time = LocalDateTime.now();

				writeLog(time);

				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void writeLog(LocalDateTime currentTime) {

		if (currentTime.getSecond() == 0) {

			String timeForm = currentTime.format(formatter);
			logger.trace(timeForm);

		} else if (currentTime.getMinute() == 0) {

			String timeForm = currentTime.format(formatter);
			logger.error(timeForm);

		} else {

			String timeForm = currentTime.format(formatter);
			logger.warn(timeForm);
		}

	}
}