package com.romansun.gui.controller.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import com.romansun.gui.controller.AbstractController;
import com.romansun.gui.utils.Dialog;
import com.romansun.gui.utils.Resources;
import com.romansun.hibernate.logic.Visitor;
import com.romansun.reports.ReportBuilder;
import com.romansun.reports.ReportsSaver;
import com.romansun.reports.logic.Report;

public class MainWindowController extends AbstractController implements Initializable {
	private final static Logger LOG = Logger.getLogger(MainWindowController.class);
	
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
		try {
			// loading tabs and add to TabPane
			firstTab.setContent(loadTab(new Resources().getFirstTabFXML().toURL(), null));
			secondTab.setContent(loadTab(new Resources().getSecondTabFXML().toURL(), null));
			thirdTab.setContent(loadTab(new Resources().getThirdTabFXML().toURL(), null));
			LOG.info("��� ���� ���� ������� ���������");
		} catch (Exception e) {
			LOG.error("������ ��� �������� Tabs: ", e);
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
				LOG.info("��� ����� � ����� ���� ��������, ����� " + report.getName() + " �����������");
			} catch (Exception e) {
				LOG.error("������ ��� ������ ������� � �������� ������: " , e);
			}
		}
		
	}
	
	@FXML
	private void clickOnClose() {
		System.exit(0);
	}
	
	@FXML
	private void clickOnAbout() {
		Dialog.showInfo("��������� \"���� �������\" ������������� ��� ���������� ��������." +
				"\n����� ���������: �������� ����� �������������" +
				"\n�� ���� �������� ���������� �� ������ roman.rybalkin24@gmail.com" +
				"\n��� ����� �������� �");
	}
	
	// method for loading Tab from fxml-file
	private AnchorPane loadTab(URL path_to_tab, Object controller) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(path_to_tab);
    	fxmlLoader.setController(controller);
    	fxmlLoader.load();
    	AnchorPane pane = fxmlLoader.getRoot();
    	
    	return pane;
	}
}
