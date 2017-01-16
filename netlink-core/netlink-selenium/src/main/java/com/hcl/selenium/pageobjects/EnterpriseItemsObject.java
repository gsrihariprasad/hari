package com.hcl.selenium.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.hcl.mongodb.DaoServices.GetDbXpathsAndElemetsDao;
import com.hcl.utility.DriversUtility;
import com.hcl.utility.Log;

public class EnterpriseItemsObject extends BasePageObject{
	public static final String LOCATOR_PREFIX = "EnterpriseItemsObject.";

	WebDriver driver =null;// Login.getDriver();

	public EnterpriseItemsObject() {

	}

	static boolean check = false;

	static String parentWindowHandler = null;

	public boolean createEnterpriseItems(String itemName,String itemDescription ) throws InterruptedException {
		
		//JSONObject jsonObj = new JSONObject(itemValues);   CreateEnterpriseItems   CreateEnterpriseItems
		DriversUtility.setDriverMap("itemDriver", driver);
		DriversUtility.setDriverName("itemDriver", driver.getWindowHandle());
		
		
		
		/*String itemName =itemName1;
		String itemDescription = itemDescription1;*/
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//GetDbXpathsAndElemetsService.getXPath("EnterpriseItemsObject", "xPathForitemName","com.hcl.selenium.pageobjects.EnterpriseItemsObject"); 
		String xPathItemName =GetDbXpathsAndElemetsDao.getXPath("EnterpriseItemsObject", "xPathForitemName","com.hcl.selenium.pageobjects.EnterpriseItemsObject"); 
		sendKeys(xPathItemName.trim(), itemName.trim(), driver);
		String xPathItemDesc =GetDbXpathsAndElemetsDao.getXPath("EnterpriseItemsObject", "xPathForitemName","com.hcl.selenium.pageobjects.EnterpriseItemsObject"); 
		sendKeys(xPathItemDesc.trim(), itemDescription.trim(), driver);
		String itemSub = "/html/body/div[5]/div[3]/button[1]";
		By locator = By.xpath(itemSub);
		if (click(locator, driver))
			return true;
		else
			return false;
	}

	public boolean enterpriseItemPreviewBefore(String preview) {

		

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
					/*if (result) {
						WebDriverWait wait = new WebDriverWait(dr, 15000);
						Log.debug("LETS CLICK>>>>>>>>>>>>>>>>>");
   					 wait.until(ExpectedConditions.elementToBeClickable(locator1)).click();

					}*/
					// if (click(locator1, dr))
					// driver.findElement(locator1).click();
					// break;

				} catch (Exception exp) {
					Log.error("enterItemValues " + exp);

				}
			}
		} catch (Exception eeee) {
			Log.error("enterItemValues ..." + eeee);
		}
		return true;
	}

	// Here pass the driver and frame location(xpath)
	public WebDriver switchDriver(final WebDriver localDriver, final By locator) {

		// By locator = By.xpath(XPath);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(localDriver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		WebDriver lDriver = null;
		int tries = 0;
		boolean found = false;
		WebElement we = null;
		final long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < 91000) {
			Log.info("Searching for element. Try number " + (tries++));
			try {
				we = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				found = true;
				lDriver = localDriver.switchTo().frame(localDriver.findElement(locator));
				break;
			} catch (StaleElementReferenceException e) {
				Log.info("Stale element: \n" + e.getMessage() + "\n");
				return null;
			} catch (NoSuchElementException nse) {
				Log.info("No such element: \n" + nse.getMessage() + "\n");
				return null;
			}
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		if (found) {
			Log.info("Found element after waiting for " + totalTime + " mill.");
		} else {
			Log.info("Failed to find element after " + totalTime + " mill.");
		}

		return lDriver;
	}

	public boolean validateItem(String validationElements) {
		JSONObject jsonObj = new JSONObject(validationElements);
		try {
			Log.debug("validateItem...  ");
			Thread.sleep(5000);
		} catch (Exception eee) {

		}
		WebDriver dr1 = null;
		WebDriver dr = null;
		String driverName = null;
		try {
			Log.debug("validateItem..............2");
			if (DriversUtility.getDriverMap("itemObjectMainDriver") != null) {
				Log.debug(" if condition Driver....");
				driverName = DriversUtility.getDriverName("itemDriver");
			}

			dr = driver;

			String XPath = "/html/body/div[@id=\"windowPane\"]/div[@id=\"contentPane\"]/div[@id=\"mainPane\"]/iframe";

			Log.debug("validate Site  window title ::: " + dr.getTitle());

			dr.switchTo().window(driverName);
			Log.debug("validate Site after switching window title ::: " + dr.getTitle());

			try {
				Set<String> sts = dr.getWindowHandles();
				for (String s : sts) {
					Log.debug("window Name" + s);
					dr.switchTo().window(s);
					By locator = By.xpath(XPath);
					dr = switchDriver(dr, locator);
					if (dr != null) {
						break;
					} else {
						dr.switchTo().defaultContent();
					}
				}

			} catch (Exception error) {
				Log.error("driver error " + error.getMessage() + "  :::  " + error.getLocalizedMessage());

			}
			Log.debug(" ITS..............");
			String tablePath = "/html/body/div/div/div[@id=\"viewport\"]/div[@id=\"dataTable\"]/div[@class=\"tableRow\"]";

			/*List<WebElement> listOfDivs = listOfWebElements(tablePath, dr);*/
			List<WebElement> listOfDivs =null;
			Log.debug(" SIZE ::::::::::::::::::::::::: " + listOfDivs.size());
			String itemName = jsonObj.getString("itemName");
			String itemDescription = jsonObj.getString("itemDescription");
			int count = 0;
			for (WebElement ele : listOfDivs) {

				WebElement nameEle = ele.findElement(By.xpath("div[@class=\"tableCell col2\"]"));
				WebElement descEle = ele.findElement(By.xpath("div[@class=\"tableCell col3\"]"));
				String nameE = nameEle.getText();
				String descE = descEle.getText();

				Log.debug(nameE + "    :  " + descE);

				if (itemName.equals(nameE) && itemDescription.equals(descE)) {
					//FunctionalResultUtility.setFunctionalResult("validation success");
					Log.debug("VALIDATION SUCCESS");
					return true;
				} else {
					count++;
				}
				if (listOfDivs.size() == count) {
					//FunctionalResultUtility.setFunctionalResult("Validation Failed ( Total Records " + count + ")");
				}
			}
		} catch (Exception exp) {
			Log.error("Exception...." + exp);
			return false;
		}
		return true;
	}

	public boolean navigate(String navigationLinks) {
		String[] links = navigationLinks.split("\\|");
		String path = "/html/body/div[1]/div[3]/div/button[2]";

		try {

			driver.findElement(By.xpath(path)).click();

		} catch (Exception exp) {
			Log.debug("ELEMENT ...  " + exp);
		}
		return true;
	}

	public boolean clearPage() {

		return false;
	}
}