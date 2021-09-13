package com.d3a.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.d3a.qa.base.D3A_Base;
import com.d3a.qa.uimap.D3A_Project_Locators;

public class D3A_Project_Actions extends D3A_Base {
	
	public String projectname="AP"+System.currentTimeMillis();
	public String projectdesc="This is just a test project descripyion";

	public D3A_Project_Actions() throws IOException {
		super();
	}
	public void enterProject_Name()
	{
		driver.findElement(By.xpath(D3A_Project_Locators.projectName_Txt)).sendKeys(projectname);
	}
	public void enterProject_Desc()
	{
		driver.findElement(By.xpath(D3A_Project_Locators.projectDescription_Txt)).sendKeys(projectdesc);
	}
	public void clickAdd_Btn()
	{
		driver.findElement(By.xpath(D3A_Project_Locators.projectAdd_Btn)).click();
	}
	public String getProjectName()
	{
		WebElement header=driver.findElement(By.xpath("//span[text()='"+projectname+"']"));
		
		String s=header.getText();
		return s;
	}
	public void clickHeader() throws IOException
	{
		WebElement header=driver.findElement(By.xpath("//span[text()='"+projectname+"']"));
		header.click();
	}

}
