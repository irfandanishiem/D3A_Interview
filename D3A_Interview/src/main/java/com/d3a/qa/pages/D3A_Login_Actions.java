package com.d3a.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.d3a.qa.base.D3A_Base;
import com.d3a.qa.uimap.D3A_Login_Locators;

public class D3A_Login_Actions extends D3A_Base{

	public D3A_Login_Actions() throws IOException {
		super();
	}
	
	public void clickLoginTab()
	{
		driver.findElement(By.xpath(D3A_Login_Locators.login_Btn)).click();
	}
	public void enterLoginCredentials(String email,String password)
	{
		driver.findElement(By.xpath(D3A_Login_Locators.email_Txt)).sendKeys(email);
		driver.findElement(By.xpath(D3A_Login_Locators.password_Txt)).sendKeys(password);
	}
	public void clickLoginBtn()
	{
		driver.findElement(By.xpath(D3A_Login_Locators.login_Submit_Btn)).click();
	}

}
