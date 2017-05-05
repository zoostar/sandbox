package net.zoostar.sandbox.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	static final Logger logger = LogManager.getLogger(MainController.class);
	
//	@ApiIgnore
//	@RequestMapping(value="/", produces=MediaType.TEXT_HTML_VALUE)
//	public void loadMain(HttpServletResponse response) throws IOException {
//		logger.info("Redirecting to swagger-ui.html");
//		response.sendRedirect("swagger-ui.html");
//	}

	@RequestMapping(value="/", produces=MediaType.TEXT_HTML_VALUE)
	public String loadMain(HttpServletResponse response) throws IOException {
		logger.debug("Redirecting to index.jsp");
		logger.info("Redirecting to index.jsp");
		return "index";
	}
}
