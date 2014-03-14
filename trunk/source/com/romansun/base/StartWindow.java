package com.romansun.base;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.romansun.config.Resources;
import com.romansun.gui.viewbuilder.WindowBuilder;

public class StartWindow {
	private final static Logger LOG = Logger.getLogger(StartWindow.class);
	static {
		File config = new File("config/log4j.properties");
		if (!config.exists()) {
			config = Resources.getInstance().getLog4jProperties();
			LOG.info("������� ���� log4j.properties �� ������ - ������������ ����������");
		}
		PropertyConfigurator.configure(config.getPath());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("����� ���������");
		
		WindowBuilder window = new WindowBuilder();
		window.show();
	}
}
