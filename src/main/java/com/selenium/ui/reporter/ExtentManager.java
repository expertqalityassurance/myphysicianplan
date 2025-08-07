package com.selenium.ui.reporter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	public static ExtentReports extentreports;

	public synchronized static ExtentReports getInstance() {
		if (extentreports == null) {
			return createInstance();
		} else {
			return extentreports;
		}
	}

	public static ExtentReports createInstance() {
		String fileName = "src/main/resources/report/Automation.html";
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//fileName = fileName.replace("TEMP",timeStamp);
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Myphysicianplan");
		extentreports = new ExtentReports();
		extentreports.attachReporter(htmlReporter);
		return extentreports;
	}
}
