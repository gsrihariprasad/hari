package com.hcl.mongodb.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.testsuite.entities.TestSuites;

@Component(value="commonDaoImpl")
public class CommonDaoImpl {

	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonDaoImpl.class);
	private DbPageObjects pageObjects;

	public TestSuites getActions(String collectionName1,String actionName) {
		
		//"_id" : "sitecreate",
		
		logger.info(" Query  +"  +query(where(new TestSuites().getSuiteName()).is(actionName).and("_id").is(actionName)));
		TestSuites testSuites = mongoTemplate.findOne(query(where(new TestSuites().getSuiteName()).is(actionName).and("_id").is(actionName)), TestSuites.class);
		logger.info(actionName +":::  CommonDaoImpl testsuiteId getID :: "+testSuites.getId());
		
		logger.info("CommonDaoImpl ..  getting DbPageObjects .");
		List<DbPageObjects> pages = (ArrayList) mongoTemplate.findAll(DbPageObjects.class, "PageObjects");

		new CommonInterfaceImpl(pages);
	
		return testSuites;

	}
	
	
	
	

}
