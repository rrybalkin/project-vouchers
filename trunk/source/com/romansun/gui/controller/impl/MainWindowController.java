package com.romansun.gui.controller.impl;

import java.io.File;
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
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import com.romansun.config.Resources;
import com.romansun.gui.controller.AbstractController;
import com.romansun.gui.utils.Dialog;
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
			mainTabPane = tabPane;
			
			// loading tabs and add to TabPane
			File firstTabFile = new File("resource/fxml/first_tab.fxml");
			if (!firstTabFile.exists()) {
				firstTabFile = Resources.getInstance().getFirstTabFXML();
				LOG.info("������� ���� first_tab.fxml �� ������, ������������ ����������");
			}
			File secondTabFile = new File("resource/fxml/second_tab.fxml");
			if (!secondTabFile.exists()) {
				secondTabFile = Resources.getInstance().getSecondTabFXML();
				LOG.info("������� ���� second_tab.fxml �� ������, ������������ ����������");
			}
			File thirdTabFile = new File("resource/fxml/third_tab.fxml");
			if (!thirdTabFile.exists()) {
				thirdTabFile = Resources.getInstance().getThirdTabFXML();
				LOG.info("������� ���� third_tab.fxml �� ������, ������������ ����������");
			}
			File fourthTabFile = new File("resource/fxml/fourth_tab.fxml");
			if (!fourthTabFile.exists()) {
				fourthTabFile = Resources.getInstance().getFourthTabXML();
				LOG.info("������� ���� fourth_tab.fxml �� ������, ������������ ����������");
			}
			
			firstTab.setContent(loadTab(firstTabFile.toURL(), null));
			secondTab.setContent(loadTab(secondTabFile.toURL(), null));
			thirdTab.setContent(loadTab(thirdTabFile.toURL(), null));
			fourthTab.setContent(loadTab(fourthTabFile.toURL(), null));
			LOG.info("��� ���� ���� ������� ���������");
		} catch (Exception e) {
			LOG.error("������ ��� �������� Tabs: ", e);
		}
	}
	@FXML
	private TabPane tabPane;
	@FXML
	private Tab firstTab;
	@FXML
	private Tab secondTab;
	@FXML
	private Tab thirdTab;
	@FXML
	private Tab fourthTab;
	
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
