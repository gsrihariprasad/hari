package com.srihari;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconf {
	@Bean 
	public myBean mybean(){
	
	myBean m=new myBean();
	m.setName("GOOD SRIHARI");
	return m;
	}
}
