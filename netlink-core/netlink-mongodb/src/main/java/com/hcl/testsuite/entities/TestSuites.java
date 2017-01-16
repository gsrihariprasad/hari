package com.hcl.testsuite.entities;

import java.util.Date;
import java.util.LinkedList;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TestSuites")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class TestSuites {

	@Id	
	String id;
	
	@LastModifiedBy
	protected String lastModifiedBy;
	
	@Version
	protected Long version;

	@CreatedBy
	private String createdBy;
	@CreatedDate
    private Date creationTime;
	
	LinkedList<TestSteps>  steps;
	String suiteName;
	
	@LastModifiedDate
	private Date lastModifiedDate;
	
    private String pageName;
    
    private String pageActionName;
    
 

	
    
    public String getPageActionName() {
		return pageActionName;
	}

	public void setPageActionName(String pageActionName) {
		this.pageActionName = pageActionName;
	}

	
	
	
	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LinkedList<TestSteps> getSteps() {
		return steps;
	}

	public void setSteps(LinkedList<TestSteps> steps) {
		this.steps = steps;
	}

	
}
