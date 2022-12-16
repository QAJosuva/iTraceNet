package com.staf.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Feature",glue="com.staf.stepdefination",tags="@Registration",
plugin = { "pretty","html:target/html-reports/report.html" },
monochrome = true)
public class Testrunner {
	
//	public class TestRunner {
//		@AfterClass
//		public static void writeExtentReport() {
//			Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//		}
//	ADD Plugin in @cucumberOption :-"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"

}
