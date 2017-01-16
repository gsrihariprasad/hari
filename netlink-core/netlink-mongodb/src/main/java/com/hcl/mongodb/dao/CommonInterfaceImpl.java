package com.hcl.mongodb.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.hcl.mongodb.DaoServices.CommonInterface;
import com.hcl.mongodb.pageobjects.DbPageObjects;
import com.hcl.mongodb.pageobjects.PageXpaths;



@Component(value="commonInterface")
public class CommonInterfaceImpl  implements CommonInterface{
	
	private static final Logger logger = LoggerFactory.getLogger(CommonInterfaceImpl.class);
	static List<DbPageObjects> pageObjects;

	@Autowired
	MongoTemplate mongoTemplate;
	public CommonInterfaceImpl(){
		
	}
	CommonInterfaceImpl(List<DbPageObjects> pages){
		
		pageObjects=pages;
		
	}
	
	
	public static List<DbPageObjects> getPageObjects(){
		return pageObjects;
	}
	
	private static HashMap<String, String> pageClasses = new HashMap<String, String>();
	private static HashMap<String, String> pageElementsXPath = new HashMap<String, String>();

	
	public static Map<String, String> initXpath(String collectionName) throws Exception {
		// clear all entries in the HashMap(s)
		pageClasses.clear();
		pageElementsXPath.clear();
		List<DbPageObjects> pages = pageObjects;

		List<PageXpaths> pageXpaths;
		for (DbPageObjects pageObjects : pages) {

			logger.info(pageObjects.getPageClass());
			logger.info(pageObjects.getPageName());

			if (pageObjects != null) {
				pageXpaths = pageObjects.getPageXpaths();
				pageClasses.put(pageObjects.getPageName(), pageObjects.getPageClass());

				for (PageXpaths xpath : pageXpaths) {
					if (xpath != null && !xpath.equals("")) {
						pageElementsXPath.put(pageObjects.getPageName() + "." + xpath.getPageElement(),
								xpath.getPageElementXPath());
					}
				}
			}

		}
		
		return pageElementsXPath;
	}
	
	
	public String getXPath(String collectionName, String element) {
		
		try{
		if(pageElementsXPath.containsKey(collectionName+"."+element))
			return pageElementsXPath.get(collectionName+"."+element);
		else{
		initXpath(collectionName);
		return pageElementsXPath.get(collectionName+"."+element);
		}
		}catch(Exception exp){
			logger.error("Exception Occured "+exp);
		}
		
		return null;
	}
	
	
	
	
	
	
	
	}
