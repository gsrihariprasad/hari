package com.hcl.main_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.hcl.mongodb.dao.CommonServiceImpl;
import com.hcl.selenium.common.formpages.TestDataForm;
import com.hcl.testng.services.TestNgService;
import com.hcl.testsuite.entities.TestSuites;

@Service

public class ExecuteTestNg {

	@Autowired
	TestNgService testNgService;
	
	@Autowired
	CommonServiceImpl commonServiceImpl;
	@Autowired
	TestDataForm testDataForm;
	public  void getExecute(){
		  TestSuites  pages1=commonServiceImpl.getActions("PageObjects","sitecreate");
			
		  testDataForm.setObjNavigatioName("Sites");
		  testNgService.startSuite(pages1,"teststst");
	}

}
