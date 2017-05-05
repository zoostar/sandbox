package net.zoostar.sandbox.web.config;

import static org.apache.logging.log4j.web.Log4jWebSupport.LOG4J_CONFIG_LOCATION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.web.Log4jServletContextListener;

public class CustomLog4jServletContextListener extends Log4jServletContextListener {

	static final Logger logger = LogManager.getLogger(CustomLog4jServletContextListener.class);
	
	static final String SPRING_PROFILE_ACTIVE = "spring.profiles.active";
	static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";
	static final String DEFAULT_ENV = "dev";
	static final Collection<String> SUPPORTED_ENVS = new ArrayList<>(Arrays.asList(DEFAULT_ENV,"int","qa","prod"));
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		String env = parseEnvironment(event.getServletContext());
		
		String log4jConfiguration = "log4j2.properties";
		if(DEFAULT_ENV.equals(env)) {
			log4jConfiguration = "/WEB-INF/dev/log4j2.properties";
		} else if("int".equals(env)) {
			log4jConfiguration = "/WEB-INF/int/log4j2.properties";
		}
		event.getServletContext().setInitParameter(LOG4J_CONFIG_LOCATION, log4jConfiguration);
		
		super.contextInitialized(event);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//Do nothing
	}

	protected String parseEnvironment(ServletContext context) {
		String strProfiles = System.getProperty(SPRING_PROFILE_ACTIVE) == null ?
				context.getInitParameter(SPRING_PROFILE_DEFAULT) : System.getProperty(SPRING_PROFILE_ACTIVE);
		String[] profiles = strProfiles == null ? new String[]{DEFAULT_ENV} : strProfiles.split(",");
		String env = null;
		for(String profile : profiles) {
			if(SUPPORTED_ENVS.contains(profile.toLowerCase())) {
				env = profile.toLowerCase();
				break;
			}
		}
		return env;
	}
}
