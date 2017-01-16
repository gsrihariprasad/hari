package com.hcl.selenium.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hcl.mongodb.DaoServices.GetDbXpathsAndElemetsDao;
import com.hcl.utility.DriversUtility;
import com.hcl.utility.Log;

public class SiteObject implements PageObjectInterface/*extends BasePageObject*/ {


	WebDriver driver=null;

	public SiteObject() {

	}

	static boolean check = false;

	// siteName
/*	@DataProvider(name = "sitecreate")
	public Object[][] sitecreatebuttonclickdata(Method m) {
		// DummyTestCaseForm ff=CommonUtility.getFormData();

		return new Object[][] { new Object[] { "YZZ", "Descriptions TestYYZ" } };
		// return new Object[][] { new Object[] {
		// ff.getSiteName(),ff.getDescription() }};

	}*/

	//@Test
	public void sitecreatebuttonclick(WebDriver driver) {
		Log.debug("SiteObject sitecreate button clicked");
		String xpathForCreateButton = null;
		if (check) {
			xpathForCreateButton = GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xpathForCreateButton","com.hcl.selenium.pageobjects.SiteObject");
			// String createXpath = "/html/body/div[1]/div[3]/div/button[11]";
			// //createButtonXpath

			int num = 0;
			while (!clickAndWait(xpathForCreateButton, 1, driver)) {
				++num;
				Log.error(num + " attempeting to find sitecreatebuttonclick " + xpathForCreateButton);
			}
		}
	}

	@Test/*(dependsOnMethods = { "loginInputs", "appCardsNavigation" ,"tabCardsNavigation","objNavinagation"})*/
	@Parameters({"createSite_SiteId","createSite_SiteDesc","driverName"})
	public void creatSite(String createSite_SiteId, String createSite_SiteDesc,final String driverName) {
		Log.debug("Entered to SiteObject creatSite()");
		
		driver=DriversUtility.getDriverMap(driverName);
		check = true;

		sitecreatebuttonclick(driver);

		pause(1);

		DriversUtility.setDriverMap(driverName, driver);
		DriversUtility.setDriverName(driverName, driver.getWindowHandle());

		String sitName = createSite_SiteId;
		String siteDescription = createSite_SiteDesc;

		String xPathSiteName =GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xPathForSiteName","com.hcl.selenium.pageobjects.SiteObject"); 
		// "/html/body/div[5]/div[2]/div[2]/div[3]/div/div/table/tbody/tr/td[1]/input";
		int num = 0;
		while (!sendKeys(xPathSiteName.trim(), sitName.trim(), driver)) {
			++num;
			Log.error(num + " attempeting to find creatSite " + xPathSiteName);
		}
		String xPathSiteDesc =GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xPathForSiteDesc","com.hcl.selenium.pageobjects.SiteObject"); // commonInterface.getXPath("SiteObject", "xPathForSiteDesc");
		// "/html/body/div[5]/div[2]/div[2]/div[4]/div/input";
		sendKeys(xPathSiteDesc.trim(), siteDescription.trim(), driver);

		String siteSub = GetDbXpathsAndElemetsDao.getXPath("SiteObject", "xPathForsiteSub","com.hcl.selenium.pageobjects.SiteObject"); //commonInterface.getXPath("SiteObject", "xPathForsiteSub");
		// "/html/body/div[5]/div[3]/button[1]";

		By locator = By.xpath(siteSub);
		if (click(locator, driver)) {

			Log.debug("site creation successfully completed");

		} else {
			Log.error("site creation not completed");

		}
		Log.debug("SiteObject site create completed..");
		sitePreviewBefore();
	}

	public void sitePreviewBefore() {

		try {
			Thread.sleep(20000);
			String subdriver = null;
			Set<String> handles = driver.getWindowHandles(); // get all window
			// handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				WebDriver dr = null;
				subdriver = iterator.next();
				Log.debug(subdriver);
				dr = driver.switchTo().window(subdriver);
				try {
					Log.debug("K GOOD.............1");
					String path = "/html/body/div[1]/div[3]/div/button[2]";
					By locator1 = By.xpath(path);
					WebElement result = checkAndReturnElement(locator1, dr);
					result.click();

				} catch (Exception exp) {
					Log.error("enterSiteValues " + exp);

				}
			}
		} catch (Exception eeee) {
			Log.error("enterSiteValues ..." + eeee);
		}

	}

}
