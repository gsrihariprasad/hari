package com.hcl.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.mongodb.dao.CommonDaoImpl;
import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.testsuite.entities.TestSuites;



@RestController
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	DbPageObjects pageObjects;
	  @Autowired
		MongoTemplate mongoTemplate;
	  /* @Autowired
	   TestNgServiceImpl testNgService;*/
	
	@Autowired
	@Qualifier("commonDaoImpl") 
	CommonDaoImpl commonDaoImpl;
	@Autowired
	SiteObjectInsertion siteObjectInsertion;
	
	@RequestMapping("/start_sitecreate")
	public String start_sitecreate() throws Exception {
		//siteObjectInsertion.pageObjects();
		TestSuites  pages1=commonDaoImpl.getActions("PageObjects","sitecreate");
		
		
		//testNgServiceImpl.startSuite(pages1,"test98");
		return "demo";
	}

	@RequestMapping("/start_routingcreate")
	public String start_routingcreate() throws Exception {
		//siteObjectInsertion.pageObjects();
		TestSuites  pages1=commonDaoImpl.getActions("PageObjects","createRouting");
		
		//System.out.println(" mongoConfiguration : "+mongoConfiguration.mongoTemplate().findAll(DbPageObjects.class));
		//testNgServiceImpl.startSuite(pages1,"test90");
		return "demo";
	}
	
	//http://localhost:8050/start/temp2/createRouting/Routings
	//http://localhost:8050/start/temp2/sitecreate/Sites
	@RequestMapping(value="/start/{id}/{name}/{navigationname}")
	@ResponseBody
	public String method8(@PathVariable("id") String id, @PathVariable("name") String name,@PathVariable("navigationname") String navigationname){
		
        TestSuites  pages1=commonDaoImpl.getActions("PageObjects",name);
		
    
		//testNgServiceImpl.startSuite(pages1,id);
		
		return "method8 with id= "+id+" and name="+name;
	}
	
	@RequestMapping("/addCollection")
	public String addCollections() {

		
		siteObjectInsertion.siteObjectss();
		//testNgServiceImpl.startSuite();
		return "demo";
	}

}
