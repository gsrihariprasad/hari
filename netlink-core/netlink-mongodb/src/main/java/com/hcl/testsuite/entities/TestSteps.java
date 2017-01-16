package com.hcl.testsuite.entities;

import java.util.LinkedList;

public class TestSteps {

	private String id;

	private String className;
	LinkedList<TestStepsActions> testStepsActions;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public LinkedList<TestStepsActions> getTestStepsActions() {
		return testStepsActions;
	}

	public void setTestStepsActions(LinkedList<TestStepsActions> testStepsActions) {
		this.testStepsActions = testStepsActions;
	}

}
