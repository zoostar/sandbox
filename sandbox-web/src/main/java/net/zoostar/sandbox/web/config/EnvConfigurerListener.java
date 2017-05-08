package net.zoostar.sandbox.web.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EnvConfigurerListener implements ServletContextListener {

	static final String SPRING_PROFILE_ACTIVE = "spring.profiles.active";
	static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";
	static final String DEFAULT_ENV = "dev";
	static final Collection<String> SUPPORTED_ENVS = new ArrayList<>(Arrays.asList(DEFAULT_ENV,"int","qa","prod"));
	
	static final String ENV_VALUE = "env.value";
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		String env = parseEnvironment(event.getServletContext());
		event.getServletContext().setInitParameter(ENV_VALUE, env);
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
