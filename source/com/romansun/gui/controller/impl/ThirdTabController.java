package com.romansun.gui.controller.impl;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import com.romansun.gui.controller.AbstractController;
import com.romansun.reports.logic.Report;

public class ThirdTabController extends AbstractController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Integer curMonth = new Date().getMonth();
		Integer curYear = new Date().getYear() + 1990;
		
		cbMonth.setConverter(new MonthConverter());
		Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		cbMonth.getItems().addAll(months);
		cbMonth.getSelectionModel().select(curMonth-1);
		
		cbYear.setConverter(new YearConverter());
		Integer[] years = {2012, 2013};
		cbYear.getItems().addAll(years);
		cbYear.getSelectionModel().select(curYear);
	}
	
	@FXML
	private ComboBox<Integer> cbMonth;
	@FXML
	private ComboBox<Integer> cbYear;
	@FXML
	private ListView<Report> lvReports;
	@FXML
	private TextField txtMask;
	
	private class MonthConverter extends StringConverter<Integer> {

		private Map<String, Integer> months = new HashMap<String, Integer>();
		
		{
			months.put("������", 1);
			months.put("�������", 2);
			months.put("����", 3);
			months.put("������", 4);
			months.put("���", 5);
			months.put("����", 6);
			months.put("����", 7);
			months.put("������", 8);
			months.put("��������", 9);
			months.put("�������", 10);
			months.put("������", 11);
			months.put("�������", 12);
		}
		
		@Override
		public Integer fromString(String month) {
			return months.get(month);
		}

		@Override
		public String toString(Integer month) {
			for (String key : months.keySet()) {
				if (month.equals(months.get(key)))
					return key;
			}
			return null;
		}
	}
	
	private class YearConverter extends StringConverter<Integer> {
		
		@Override
		public Integer fromString(String month) {
			return Integer.parseInt(month);
		}

		@Override
		public String toString(Integer month) {
			return month.toString();
		}
	}
}
