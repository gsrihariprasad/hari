package com.hcl.main_class;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.inpututility.pageobject.ApplicationsCardsNavigationInsertion;
import com.hcl.inpututility.pageobject.LogintInsertionUtility;
import com.hcl.inpututility.pageobject.RoutingObjectInsertion;
import com.hcl.inpututility.pageobject.SiteObjectInsertion;

@Configuration
@EnableAutoConfiguration
public class TempUtilityCfg {

	@Bean
	public SiteObjectInsertion siteObjectInsertion() {

		return new SiteObjectInsertion();
	}

	@Bean
	public ApplicationsCardsNavigationInsertion applicationsCardsNavigationInsertion() {
		return new ApplicationsCardsNavigationInsertion();
	}

	@Bean
	public LogintInsertionUtility logintInsertionUtility() {
		return new LogintInsertionUtility();
	}
	@Bean
	public RoutingObjectInsertion routingObjectInsertion(){
		return new RoutingObjectInsertion();
	}
	
	
	@Bean
	public ExecuteTestNg executeTestNg(){
		return new ExecuteTestNg();
	}
}
