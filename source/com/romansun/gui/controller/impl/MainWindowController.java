package com.romansun.gui.controller.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import com.romansun.gui.controller.AbstractController;
import com.romansun.gui.utils.Dialog;
import com.romansun.hibernate.logic.Visitor;
import com.romansun.reports.ReportBuilder;
import com.romansun.reports.ReportsSaver;
import com.romansun.reports.logic.Report;

public class MainWindowController extends AbstractController implements Initializable {
	
	private static Observable observable = new Observable() {
		public void notifyObservers(Object arg) {
			setChanged();
			super.notifyObservers(arg);
		}
	};
	
	public static void addObserver(Observer o) {
		observable.addObserver(o);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// paths to tabs
		final String PATH_TO_FIRST_TAB = "fxml\\first_tab.fxml";
		final String PATH_TO_SECOND_TAB = "fxml\\second_tab.fxml";
		final String PATH_TO_THIRD_TAB = "fxml\\third_tab.fxml";
		
		// loading tabs and add to TabPane
		try {
			firstTab.setContent(loadTab(PATH_TO_FIRST_TAB, null));
			secondTab.setContent(loadTab(PATH_TO_SECOND_TAB, null));
			thirdTab.setContent(loadTab(PATH_TO_THIRD_TAB, null));
		} catch (Exception ex) {
			System.out.println("������ ��� �������� Tabs: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	@FXML
	private Tab firstTab;
	@FXML
	private Tab secondTab;
	@FXML
	private Tab thirdTab;
	
	@FXML
	private void resetTalons() {
		int answer = Dialog.showQuestion("�� �������, ��� ������ �������� ����� � ����� ��� ���� �����������?", null);
		if (answer == 1 /*YES*/) {
			// Create report
			Report report = null;
			try {
				Collection<Visitor> visitors = dao.getVisitorDAO().getAllVisitors();
				ReportBuilder builder = new ReportBuilder();
				report = builder.buildReport(new ArrayList<Visitor>(visitors));
				ReportsSaver saver = new ReportsSaver(PATH_TO_REPORTS, report);
				saver.saveReport();
				// Reset talons
				dao.getTalonDAO().resetAllTalons();
				// Call to observer
				observable.notifyObservers();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// method for loading Tab from fxml-file
	private AnchorPane loadTab(String path_to_tab, Object controller) throws IOException {
		File file = new File(path_to_tab);
		if(!file.exists()) 
			throw new IOException("Cannot load file or file is not exist: " + path_to_tab);
		
    	URL fxmlURL = file.toURL();
    	FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    	fxmlLoader.setController(controller);
    	fxmlLoader.load();
    	AnchorPane pane = fxmlLoader.getRoot();
    	
    	return pane;
	}
}
