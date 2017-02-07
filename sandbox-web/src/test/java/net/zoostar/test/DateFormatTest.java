package net.zoostar.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class DateFormatTest {

	static final Logger logger = LoggerFactory.getLogger(DateFormatTest.class);

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
