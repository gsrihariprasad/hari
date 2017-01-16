package com.hcl.mongodb.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.inpututility.suites.SiteCreateSuite;
import com.hcl.mongodb.dao.CommonDaoImpl;
import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.testsuite.entities.TestSuites;


@Configuration
//@EntityScan("com.hcl")
//@EnableAutoConfiguration
public class MongoConfiguration {

/*public @Bean MongoDbFactory mongoDbFactory() throws Exception {
  UserCredentials userCredentials = new UserCredentials("joe", "secret");
  return new SimpleMongoDbFactory(new Mongo(), "database", userCredentials);
}*/

/* public @Bean MongoTemplate mongoTemplate() throws Exception {
  return new MongoTemplate(mongoDbFactory());
}*/


public @Bean DbPageObjects dbPageObjects(){
	
	return new DbPageObjects();
}
public @Bean CommonDaoImpl commonDaoImpl(){
	CommonDaoImpl commonDaoImpl=new CommonDaoImpl();
	return commonDaoImpl;
	
}


public @Bean SiteObjectInsertion siteObjectInsertion(){
	
	return new SiteObjectInsertion();
}
public @Bean LogintInsertionUtility logintInsertionUtility(){
	
	return new LogintInsertionUtility();
}
public @Bean ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion(){
	
	return new ApplicationsCardsNavigationInsertion();
}
public @Bean RoutingObjectInsertion routingObjectInsertion(){
	
	return new RoutingObjectInsertion();
}

 
public @Bean TestSuites testSuites(){
	
	return new TestSuites();
}

public @Bean SiteCreateSuite siteCreateSuite(){
	
	return new SiteCreateSuite();
}
}
