package com.d3a.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.d3a.qa.base.D3A_Base;
import com.d3a.qa.uimap.D3A_Home_Locators;

public class D3A_Home_Actions extends D3A_Base{

	public D3A_Home_Actions() throws IOException {
		super();
	}
	
	public String getHome_Title()
	{
		String s= driver.findElement(By.xpath(D3A_Home_Locators.home_Title)).getText();
		return s;
	}
	public void clickProjects_Tab()
	{
		driver.findElement(By.xpath(D3A_Home_Locators.project_Bar)).click();
	}
	public void clickNewProjects_Btn()
	{
		driver.findElement(By.xpath(D3A_Home_Locators.new_project_Btn)).click();
	}
}
