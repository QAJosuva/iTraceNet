package com.staf.utilis;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.staf.webdrivermanager.WebDriverBase;


public class ExtentReportsClass  {
//	Properties prop;
	public static ExtentReports entent;
	public static ExtentSparkReporter rep;

	public static void config(String name) {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		rep = new ExtentSparkReporter(path);
		rep.config().setReportName("Test Report");
		rep.config().setDocumentTitle("Test Automation");

		entent = new ExtentReports();
		entent.attachReporter(rep);
		entent.setSystemInfo("Tester", "joshua");
		entent.createTest(name);

	}

	public static void endTest() {
		entent.flush();
		
	}
	
//	public String getReportConfigPath(){
//		String reportConfigPath = prop.getProperty("reportConfigPath");
//		if(reportConfigPath!= null) return reportConfigPath;
//		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
//	}

}

