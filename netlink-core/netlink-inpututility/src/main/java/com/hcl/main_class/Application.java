package com.hcl.main_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.hcl.inpututility.pageobject.SiteObjectInsertion;
import com.hcl.mongodb.dao.CommonServiceImpl;

@SpringBootApplication(scanBasePackages={"com"})
@EnableAutoConfiguration
public class Application implements CommandLineRunner {
	@Autowired
	SiteObjectInsertion siteObjectInsertion;
	@Autowired
	static MongoTemplate mongoTemplate;

	@Autowired
	CommonServiceImpl commonServiceImpl;

	@Autowired
	ExecuteTestNg executeTestNg;
	 public static void main(String[] args) {
	 SpringApplication.run(Application.class, args);
	 		
	}
	 @Override
		public void run(String... args) throws Exception {
			// TODO Auto-generated method stub
		// executeTestNg=new ExecuteTestNg();
		// executeTestNg.getExecute();
		}

	
}
