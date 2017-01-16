package com.srihari;

import org.springframework.stereotype.Service;

@Service("mybean")
public class myBean {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
