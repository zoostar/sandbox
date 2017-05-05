package net.zoostar.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import net.zoostar.sandbox.web.controller.MainController;

public class DateFormatTest {

	static final Logger logger = LogManager.getLogger(MainController.class);

	private final String ISO_8601_STRING_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
	
	@Test
	public void test() {
		DateFormat dateFormatter = new SimpleDateFormat(ISO_8601_STRING_FORMAT);
		dateFormatter.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
		Date now = new Date();
		logger.debug("Formatted Date: {}", dateFormatter.format(now));
		Assert.assertFalse(StringUtils.endsWithIgnoreCase(dateFormatter.format(now), "Z"));
	}

}
