package com.jwj.russianblue.listener;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jwj.russianblue.RbSystemProperties;

@WebListener
public class RbServletContextListener implements ServletContextListener {

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
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// reserved
	}

}
