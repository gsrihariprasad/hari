package com.hcl.testng.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.inpututility.suites.SiteCreateSuite;

@Service("gatewayService")
public class GatewayService {

	@Autowired
	StartTestNgService startTestNgService;
	@Autowired
	RoutingObjectInsertion routingObjectInsertion;
	@Autowired
	SiteCreateSuite siteCreateSuite;
	@Autowired
	LogintInsertionUtility logintInsertionUtility;
	@Autowired
	SiteObjectInsertion siteObjectInsertion;
	@Autowired
	ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion;
	public void startTestSuiteExecution() throws InterruptedException{
		
		// TODO Auto-generated method stub
		
		/* logintInsertionUtility.loginPageObjects();
		 siteObjectInsertion.siteObjectss();
		 applicationsCardsNavigationInsertion.appPageObjects();
		
		 routingObjectInsertion.routingObject();
		siteCreateSuite.setTestSuite();*/
	
		startTestNgService.getSubmitalTestCases();
		//startTestNgService.getTestCases();
		
	}
}
