package com.actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.Filelib;
import com.actitime.pom.Homepage;
import com.actitime.pom.TasklistPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class Createcustomer extends BaseClass{

	@Test
public void testCreateCustomer() throws EncryptedDocumentException,InterruptedException, IOException  {
	Reporter.log("CreateCustomer",true);
	Filelib f=new Filelib();
	String customerName = f.getExcelData("CreateCustomer", 1, 3);
	String customerDescription = f.getExcelData("CreateCustomer", 1, 4);
	Homepage h=new Homepage(driver);
	h.setTaskTab();
	TasklistPage t=new TasklistPage(driver);
	t.getAddNewBtn().click();
	t.getNewCustomerOption().click();
	t.getEnterCustomerNameTbx().sendKeys(customerName);
	t.getCustomerDescriptionTbx().sendKeys(customerDescription);
	t.getSelectDD().click();
	t.getOurCompanyOption().click();
	t.getCreateCustomerBtn().click();
	
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.textToBePresentInElement(t.getVerifyCustomerName(),customerName));
String actualCustomer = t.getVerifyCustomerName().getText();
Assert.assertEquals(actualCustomer, customerName);
	}	
}

