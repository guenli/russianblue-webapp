package com.jwj.russianblue.application.listener;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jwj.russianblue.RbSystemProperties;

@WebListener
public class RbServletContextListener implements ServletContextListener {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private WebApplicationContext applicationContext;

	private void initEnvironment(String environment) {
		// reserved
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		Properties props = (Properties) applicationContext.getBean("sysProperties");
		RbSystemProperties.environment = props.getProperty(RbSystemProperties.ENVIRONMENT);

		initEnvironment(RbSystemProperties.environment);
		
		logger.info("contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// reserved
	}

}
