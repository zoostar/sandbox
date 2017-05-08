package net.zoostar.sandbox.web.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.util.Log4jWebConfigurer;

public class Log4JLocationConfigurerListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		String env = event.getServletContext().getInitParameter(EnvConfigurerListener.ENV_VALUE);
		if(env != null && env.trim().length() > 0) {
			StringBuilder location = new StringBuilder("/WEB-INF/").
					append(env).append("/log4j.properties");
			event.getServletContext().setInitParameter(Log4jWebConfigurer.CONFIG_LOCATION_PARAM, location.toString());
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//Do nothing
	}
}
