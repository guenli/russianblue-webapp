package com.jwj.russianblue.application.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@WebListener
public class RbHttpSessionEventPublisher extends HttpSessionEventPublisher {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private int sessionCount = 0;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		super.sessionCreated(event);
		sessionCount++;
		logger.debug("sessionCreated current count {}", sessionCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		super.sessionDestroyed(event);
		sessionCount--;
		logger.debug("sessionDestroyed current count {}", sessionCount);
	}

}
