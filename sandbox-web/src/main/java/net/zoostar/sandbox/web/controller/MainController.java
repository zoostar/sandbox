package net.zoostar.sandbox.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springfox.documentation.annotations.ApiIgnore;

@Controller
public class MainController {

	static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@ApiIgnore
	@RequestMapping(value="/")
	public void loadMain(HttpServletResponse response) throws IOException {
		logger.debug("Redirecting to swagger-ui.html");
		logger.info("Redirecting to swagger-ui.html");
		logger.warn("Redirecting to swagger-ui.html");
		logger.error("Redirecting to swagger-ui.html");
		response.sendRedirect("home");
	}

	@ApiIgnore
	@RequestMapping(value="/home")
	public ModelAndView loadHome() {
		logger.info("Loading home...");
		return new ModelAndView("index");
	}

}
