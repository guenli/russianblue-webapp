package com.jwj.russianblue.application.initial;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import org.springframework.web.WebApplicationInitializer;

@WebListener
public class RbWebApplicationInitializer implements WebApplicationInitializer {
	
	@Override
    public void onStartup(ServletContext container) {
//        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/example/*");
    }
	
}
