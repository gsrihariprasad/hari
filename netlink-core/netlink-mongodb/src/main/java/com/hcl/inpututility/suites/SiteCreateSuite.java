package com.hcl.inpututility.suites;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.testsuite.entities.TestSteps;
import com.hcl.testsuite.entities.TestStepsActions;
import com.hcl.testsuite.entities.TestSuites;
import com.hcl.utility.LocalDateTimeUtility;

@Service
public class SiteCreateSuite {
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	LocalDateTimeUtility localDateTimeUtility;
	@Autowired
	TestSuites testSuites;
	public void setTestSuite() {
		
		LinkedList<TestSteps> steps = new LinkedList<TestSteps>();

		TestSteps teststeps = new TestSteps();
		LinkedList<TestStepsActions> testStepsActions = new LinkedList<TestStepsActions>();

		TestStepsActions taction = new TestStepsActions();
		taction.setActionName("loginInputs");
		testStepsActions.add(taction);
		teststeps.setTestStepsActions(testStepsActions);
		teststeps.setClassName("com.hcl.selenium.pageobjects.LoginObject");
		teststeps.setId("loginInputs");
		steps.add(teststeps);

		TestSteps teststeps1 = new TestSteps();
		LinkedList<TestStepsActions> testStepsActions1 = new LinkedList<TestStepsActions>();

		TestStepsActions taction1 = new TestStepsActions();
		taction1.setActionName("appCardsNavigation");
		taction1.setNavigationdata("Engineering");
		testStepsActions1.add(taction1);

		teststeps1.setTestStepsActions(testStepsActions1);
		teststeps1.setClassName("com.hcl.selenium.pageobjects.ApplicationCardsNavigationObject");
		teststeps1.setId("appCardsNavigation");
		steps.add(teststeps1);

		TestSteps teststeps2 = new TestSteps();

		LinkedList<TestStepsActions> testStepsActions2 = new LinkedList<TestStepsActions>();

		TestStepsActions taction2 = new TestStepsActions();
		taction2.setActionName("tabCardsNavigation");
		taction2.setNavigationdata("Enterprise PDM");
		testStepsActions2.add(taction2);
		teststeps2.setTestStepsActions(testStepsActions2);
		teststeps2.setClassName("com.hcl.selenium.pageobjects.TabbedCardsNavigationObject");
		teststeps2.setId("tabCardsNavigation");
		steps.add(teststeps2);

		TestSteps teststeps3 = new TestSteps();
		LinkedList<TestStepsActions> testStepsActions3 = new LinkedList<TestStepsActions>();

		TestStepsActions taction3 = new TestStepsActions();
		taction3.setActionName("objNavinagation");
		testStepsActions3.add(taction3);
		teststeps3.setTestStepsActions(testStepsActions3);
		teststeps3.setClassName("com.hcl.selenium.pageobjects.ObjectNavinagationObject");
		teststeps3.setId("objNavinagation");
		taction3.setNavigationdata("Sites");
		steps.add(teststeps3);

		TestSteps teststeps4 = new TestSteps();
		LinkedList<TestStepsActions> testStepsActions4 = new LinkedList<TestStepsActions>();

		TestStepsActions taction4 = new TestStepsActions();
		taction4.setActionName("sitecreatebuttonclick");
		TestStepsActions taction5 = new TestStepsActions();
		taction5.setActionName("creatSite");
		testStepsActions4.add(taction4);
		testStepsActions4.add(taction5);
		teststeps4.setTestStepsActions(testStepsActions4);

		teststeps4.setClassName("com.hcl.selenium.pageobjects.SiteObject");
		teststeps4.setId("creatSite");
		
		steps.add(teststeps4);

		
		testSuites.setId("creatSite");
		testSuites.setSuiteName("creatSite");
		testSuites.setCreatedBy("G SriHari");
		testSuites.setLastModifiedBy("G SriHari");
		testSuites.setLastModifiedDate(localDateTimeUtility.getDate());
		testSuites.setCreationTime(localDateTimeUtility.getDate());
		testSuites.setSteps(steps);
		//testSuites.setPageName("creatSite");
		testSuites.setPageActionName("creatSite");
		mongoTemplate.save(testSuites);
	}
	
}
