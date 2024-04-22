package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasklistPage {
@FindBy(xpath="//div[text()='Add New']")
private WebElement addNewBtn;

@FindBy(xpath="//div[text()='+ New Customer']")
private WebElement newCustomerOption;
	
@FindBy(id="customerLightBox_nameField")
private WebElement enterCustomerNameTbx;

@FindBy(id="customerLightBox_descriptionField")
private WebElement customerDescriptionTbx;

@FindBy(xpath="//button[contains(text(),'Select')]")
private WebElement selectDD;

@FindBy(xpath="//a[text()='Our Company']")
private WebElement ourCompanyOption;

@FindBy(xpath="//span[text()='Create Customer']")
private WebElement createCustomerBtn;

@FindBy(xpath="//div[@class='navigationLinks']/../div[2]")
private WebElement verifyCustomerName;

public TasklistPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getAddNewBtn() {
	return addNewBtn;
}
public WebElement getNewCustomerOption() {
	return newCustomerOption;
}
public WebElement getEnterCustomerNameTbx() {
	return enterCustomerNameTbx;
}
public WebElement getCustomerDescriptionTbx() {
	return customerDescriptionTbx;
}
public WebElement getSelectDD() {
	return selectDD;
}
public WebElement getOurCompanyOption() {
	return ourCompanyOption;
}
public WebElement getCreateCustomerBtn() {
	return createCustomerBtn;
}
public WebElement getVerifyCustomerName() {
	return verifyCustomerName;
}

}






