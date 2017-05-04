package net.zoostar.sandbox.web.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLog4jServletContextListener implements ServletContextListener {

	static final Logger logger = LoggerFactory.getLogger(CustomLog4jServletContextListener.class);
	
	static final String SPRING_PROFILE_ACTIVE = "spring.profiles.active";
	static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";
	static final String DEFAULT_ENV = "dev";
	static final Collection<String> SUPPORTED_ENVS = new ArrayList<>(Arrays.asList(DEFAULT_ENV,"int","qa","prod"));
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
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
		
		String path = new StringBuilder("/WEB-INF/").append(env).append("/log4j.properties").toString();
		try {
			URL url = context.getResource(path);
			PropertyConfigurator.configure(url);
		} catch (MalformedURLException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//Do nothing
	}

}
