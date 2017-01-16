package com.hcl.selenium.pageobjects;

import com.google.inject.AbstractModule;

public class ChildModule extends AbstractModule {
    @Override
    protected void configure() {
    	
    /*	ApplicationContext ctx = new AnnotationConfigApplicationContext(GetMonogInstance.class);

try{		   
 browser = ctx.getBean(Browser.class);
 }
catch(Exception exp){
	System.out.println("EXCEPTION .... "+exp);
}*/
        bind(Browser.class).toInstance(new Browser());
    }
}
