package com.rrybalkin;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.rrybalkin.utils.Resources;
import com.rrybalkin.gui.WindowBuilder;

public class App {
	private final static Logger LOG = Logger.getLogger(App.class);
	static {
		PropertyConfigurator.configure(Resources.getResource(Resources.LOG4J_CONFIG).getPath());

		System.setProperty("file.encoding", "UTF-8");
		LOG.info("Default encoding set to UTF-8");
	}

	public static void main(String[] args) {
		LOG.info("Start Application");
		
		WindowBuilder window = new WindowBuilder();
		window.show();
	}
}
