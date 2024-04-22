package com.actitime.generic;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.Homepage;
import com.actitime.pom.Loginpage;

public class BaseClass {
public static	WebDriver driver;
	@BeforeTest
	public void openBrowser() {
	Reporter.log("openBrowser",true);	
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeBrowser() {
	Reporter.log("closeBrowser",true);
	driver.close();
	}
	
	@BeforeMethod
	public void login() throws IOException {
	Reporter.log("login",true);
	Filelib f=new Filelib();
	String url = f.getPropertyData("url");
	String un = f.getPropertyData("username");
	String pw = f.getPropertyData("password");
	driver.get(url);
	Loginpage l=new Loginpage(driver);
	l.setLogin(un,pw);
	}	

	@AfterMethod
	public void logout() {
	Reporter.log("logout",true);
	Homepage h=new Homepage(driver);
	h.setLogout();
	}
}


 