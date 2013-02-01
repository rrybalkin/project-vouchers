package com.romansun.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import com.romansun.reports.jaxb.InfoVisitorType;
import com.romansun.reports.jaxb.ReportType;
import com.romansun.reports.jaxb.RootType;
import com.romansun.reports.jaxb.VisitorType;
import com.romansun.reports.jaxb.VisitorsType;
import com.romansun.reports.logic.InfoVisitor;
import com.romansun.reports.logic.Report;

public class ReportsManager {
	
	private List<Report> reports;
	private String pathToReports;
	private boolean loading = false;
	
	public ReportsManager(String pathToReports) {
		this.pathToReports = pathToReports;
	}
	
	public void loadReports() {
		reports = new ArrayList<Report>();
		try {
			File dirReports = new File(pathToReports);
			if (dirReports != null && dirReports.exists()
					&& dirReports.isDirectory()) {
				File[] xmlFiles = dirReports.listFiles();
				for (File xmlReport : xmlFiles) {
					Report report = parseReport(xmlReport);
					reports.add(report);
				}
			}
			loading = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Report> getReports() {
		if (!loading) {
			loadReports();
		}
		return reports;
	}
	
	public List<Report> getReportsByDate(Integer month, Integer year) {
		if (!loading) {
			loadReports();
		}
		List<Report> needReports = new ArrayList<Report>();
		for (Report report : reports) {
			Integer curMonth = report.getMonth();
			Integer curYear = report.getYear();
			if (curMonth.equals(month) && curYear.equals(year)) {
				needReports.add(report);
			}
		}
		
		return needReports;
	}
	
	@SuppressWarnings("unchecked")
	private Report parseReport(File xmlReport) throws Exception {
		// Initialize JAXB
		JAXBContext jaxb = JAXBContext.newInstance("com.romansun.reports.jaxb");
		Unmarshaller unmarshaler = jaxb.createUnmarshaller();
		JAXBElement<RootType> rootElement = (JAXBElement<RootType>) unmarshaler.unmarshal(xmlReport);

		// Get report
		RootType root = rootElement.getValue();
		ReportType reportElement = root.getReport();
		VisitorsType visitorsElement = reportElement.getVisitors();
		List<VisitorType> visitors = visitorsElement.getVisitor();
		
		List<InfoVisitor> infoVisitors = new ArrayList<InfoVisitor>();
		for (VisitorType visitor : visitors) {
			InfoVisitorType info = visitor.getInfoVisitor();
			InfoVisitor infoVisitor = new InfoVisitor();
			infoVisitor.setFIO(info.getFIO());
			infoVisitor.setLunches(info.getLunches());
			infoVisitor.setDinners(info.getDinners());
			
			infoVisitors.add(infoVisitor);
		}
		Integer month = reportElement.getMonth();
		Integer year = reportElement.getYear();
		
		Report report = new Report();
		report.setMonth(month);
		report.setYear(year);
		report.setVisitors(infoVisitors);
		
		return report;
	}
}
