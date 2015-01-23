package org.sitenv.getdc.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class GetDCListener implements ServletContextListener 
{
	private static Logger logger = Logger.getLogger(GetDCListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		logger.debug("Get DC stopped...");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		logger.debug("Get DC initialized...");
	}
}
