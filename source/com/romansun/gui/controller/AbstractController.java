package com.romansun.gui.controller;

import java.io.File;

import com.romansun.hibernate.factory.DAOFactory;

public abstract class AbstractController {
	
	protected final static String PATH_TO_REPORTS = "reports";
	protected static DAOFactory dao; 
	
	static {
		File reports = new File(PATH_TO_REPORTS);
		if (!reports.exists()) {
			reports.mkdir();
		}
		dao = DAOFactory.getInstance();
	}
	
	protected static String upFirst(String str) {
		StringBuilder res = new StringBuilder(1000);
		if (str != null && !str.isEmpty()) {
		res.append(str.substring(0, 1).toUpperCase());
		res.append(str.substring(1).toLowerCase());
		
		return res.toString();
		} else {
			return "?";
		}
	}
}