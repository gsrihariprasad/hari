package com.hcl.mongodb.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.inpututility.suites.SiteCreateSuite;
import com.hcl.selenium.common.formpages.ExecuteResultTestCasesService;
import com.hcl.selenium.common.formpages.TestCasesFormSubmit;
import com.hcl.testsuite.entities.TestSuites;



@Service("testCaseSubmitalDao")
public class TestCaseSubmitalDao {
	
	private static final Logger log = LoggerFactory.getLogger(TestCaseSubmitalDao.class);
	@Autowired
	ExecuteResultTestCasesService executeResultTestCasesService;
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	SiteObjectInsertion siteObjectInsertion;
	@Autowired
	LogintInsertionUtility logintInsertionUtility;
	@Autowired
	SiteCreateSuite siteCreateSuite;
	@Autowired
	CommonDaoImpl commonDaoImpl;
	@Autowired
	RoutingObjectInsertion routingObjectInsertion;
	@Autowired
	ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion;
	TestSuites suute;
	
	public boolean saveSubmitalTestCases(TestCasesFormSubmit testCasesFormSubmit) {
		
		
		mongoTemplate.save(testCasesFormSubmit);
		return true;
	}
	
/*public boolean getSubmitalTestCases() {
	
	TestCasesFormSubmit testCasesFormSubmit;
	
	ArrayList<TestCasesFormSubmit> arrayList=(ArrayList) mongoTemplate.findAll(TestCasesFormSubmit.class);
	//testCasesFormSubmit = mongoTemplate.findOne(query(where(new DbPageObjects().getPageName()).is(pageName).and("pageClass").is(classwithpackage)),DbPageObjects.class);
		for(TestCasesFormSubmit testCasesFormSubmits:arrayList){
	        execute(testCasesFormSubmits); 
	        }
	return true;
	}

*/

}
