package com.hcl.selenium.pageactionclass;

import org.springframework.data.mongodb.core.index.Indexed;

public class CreateEnterpriseItems {

	@Indexed(unique = true) 
	String itemName;
	@Indexed(unique = true) 
	String itemDescription;
}
