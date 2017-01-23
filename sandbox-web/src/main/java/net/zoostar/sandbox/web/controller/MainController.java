package net.zoostar.sandbox.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
public class MainController {

	static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@ApiIgnore
	@RequestMapping(value="/", produces=MediaType.TEXT_HTML_VALUE)
	public void loadMain(HttpServletResponse response) throws IOException {
		logger.info("Redirecting to swagger-ui.html");
		response.sendRedirect("swagger-ui.html");
	}
}
