package com.hcl.selenium.pageobjects;

public class Bar {
	 private final String message;

	    public Bar(final String message) {
	        this.message = message;
	    }

	    @Override
	    public String toString() {
	        return message;
	    }
}
