package com.pc.hooks;

import org.testng.log4testng.Logger;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.staf.utilis.SeleniumHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private static Logger logger=Logger.getLogger(Hooks.class);
	
	
	@Before
	public void Before(Scenario scenario) {
		logger.info("");
		SeleniumHelper.setScenerio(scenario);
		
	logger.info("");	
		
	}
	@After
	public void After(Scenario scenario) {
		SeleniumHelper.setScenerio(scenario);
		
		
	}

}
